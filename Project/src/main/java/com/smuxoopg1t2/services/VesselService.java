package com.smuxoopg1t2.services;

import com.smuxoopg1t2.model.User;
import com.smuxoopg1t2.model.Vessel;
import com.smuxoopg1t2.model.VesselIdentity;
import com.smuxoopg1t2.repository.IUserRepository;
import com.smuxoopg1t2.repository.IVesselRepository;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

//ArrayList, LinkedHashMap, Map, Optional
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


/**
 * @Service marks a Java class that performs some service, such as executing
 * business logic, performing calculations, and calling external APIs. This
 * annotation is a specialized form of the @Component annotation intended to be
 * used in the service layer.
 */
@Service
public class VesselService {

    private static final Logger log =
            LoggerFactory.getLogger(VesselService.class);

    /**
     * @Autowired is used to mark a dependency which Spring is going to resolve
     * and inject automatically.
     */
    @Autowired
    private IVesselRepository vesselRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private SubscriptionService subscriptionService;
    
    @Autowired
    private NotificationService notificationService;


    /**
     * Returns all Vessel information for a given date
     *
     * @param date the interested date to view vessel information
     * @return vesselJson is a list of JSON vessel objects stringify-ed for a
     * particular day
     */
    public String getAllVesselsByDate(String date, int userID) {
        String fromDateTime = date + " 00:00:00";
        String toDateTime = date + " 23:59:59";

        Iterable<Vessel> vessels =
                vesselRepository.findAllVesselsOnDate(fromDateTime, toDateTime);

        User user = userRepository.findById(userID);
        Iterable<Vessel> fav = user.getFavourites();
        ArrayList<Map> favList = new ArrayList<>();

        Iterable<Vessel> subs = user.getSubscriptions();
        ArrayList<Map> subList = new ArrayList<>();

        for (Vessel vessel : fav) {
            Map<String, Object> vesselMap =
                    vessel.toHashedMapFavouritesANDSubscriptions();
            favList.add(vesselMap);
        }

        for (Vessel vessel : subs) {
            Map<String, Object> vesselMap =
                    vessel.toHashedMapFavouritesANDSubscriptions();
            subList.add(vesselMap);
        }

        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Map> vesselList = new ArrayList<>();
        for (Vessel vessel : vessels) {
            boolean isFavourite = false;
            boolean isSubscribed = false;

            for (Map key : favList) {
                if (vessel.getVesselIdentity().getName().equals(key.get("name"))
                        && vessel.getVesselIdentity().getIncomingVoyage()
                        .equals(key.get("incomingVoyageNumber"))
                        && vessel.getVesselIdentity().getShiftSeqN()
                        .equals(key.get("shiftSeqN"))) {
                    isFavourite = true;
                    break;
                }
            }

            for (Map key : subList) {
                if (vessel.getVesselIdentity().getName().equals(key.get("name"))
                        && vessel.getVesselIdentity().getIncomingVoyage()
                        .equals(key.get("incomingVoyageNumber"))
                        && vessel.getVesselIdentity().getShiftSeqN()
                        .equals(key.get("shiftSeqN"))) {
                    isSubscribed = true;
                    break;
                }
            }

            Map<String, Object> vesselMap =
                    vessel.toHashedMap(isFavourite, isSubscribed);

            vesselList.add(vesselMap);
        }
        try {
            String vesselJson = mapper.writeValueAsString(vesselList);
            return vesselJson;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }


    /**
     * Checks to see if the vessel object in the method parameter exists in the
     * vessel table.
     * If there is no matching vessel found (it is a new Vessel),
     * add it to the vessel table.
     * If there is a matching vessel found, checks to see if there is a change
     * in berth timing.
     * <p>
     * !!In Both cases below berthingTime is never changed this is to keep track
     * of the first berthing time!!
     * <p>
     * If there is no change in berth timing, update all fields other than
     * 1. berthingTimeUpdated field
     * 2. berthingTimeChangeCount
     * <p>
     * If there is a change in berth timing, update all fields as per normal and
     * update
     * 1. the berthingTimeUpdated field
     * 2. berthingTimeChangeCount by adding 1 to it
     *
     * @param vessel the newly created VesselObject from api endpoint
     * @return true or false based on if the values have successfully been
     * updated in the database or not
     */
    public boolean update(Vessel vessel) {

        Optional<Vessel> optionalVessel =
                vesselRepository.findById(vessel.getVesselIdentity());

        // If Vessel does not exists in Vessel Table
        if (!optionalVessel.isPresent()) {
            /** Maybe we can implement try catch here?*/
            vesselRepository.save(vessel);
            return true;
        }

        // If Vessel exists in Vessel Table
        Vessel vesselFromDB = optionalVessel.get();

        LocalDateTime dbVesselBerthTime = vesselFromDB.getBerthingTime();
        LocalDateTime dbVesselUpdatedBerthTime =
                vesselFromDB.getUpdatedBerthingTime();
        LocalDateTime thisVesselBerthTime = vessel.getBerthingTime();

        if (dbVesselBerthTime.equals(thisVesselBerthTime)
                || (dbVesselUpdatedBerthTime != null && dbVesselUpdatedBerthTime
                .equals(thisVesselBerthTime))) {

            vessel.setBerthingTimeChangeCount(
                    vesselFromDB.getBerthingTimeChangeCount());
            vessel.setUpdatedBerthingTime(dbVesselUpdatedBerthTime);
            vessel.setBerthingTime(dbVesselBerthTime);

        } else {
            vessel.setBerthingTimeChangeCount(
                    vesselFromDB.getBerthingTimeChangeCount() + 1);
            vessel.setUpdatedBerthingTime(thisVesselBerthTime);
            vessel.setBerthingTime(dbVesselBerthTime);

            log.info("Updating existing record from " + dbVesselBerthTime);
            log.info("To  " + vessel.getUpdatedBerthingTime());

            Set<User> subbedUsers = subscriptionService.getSubByVesselId(
                    vessel.getVesselIdentity().getName(),
                    vessel.getVesselIdentity().getIncomingVoyage(),
                    vessel.getVesselIdentity().getShiftSeqN());

            if (subbedUsers != null && subbedUsers.size() > 0) {
                notificationService.sendUpdatedNotification(subbedUsers, vessel,
                        dbVesselUpdatedBerthTime);
            }
        }

        vesselRepository.save(vessel);
        return true;
    }

    /**
     * Creates a new Vessel Object created from data retrieved from the api
     * endpoint
     *
     * @param vesselLinkedHashMap the data of the new vessel information of
     *                            type LinkedHashMap
     * @return the newly created Vessel Object
     */
    public static Vessel createVesselObj(
            LinkedHashMap vesselLinkedHashMap) {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        try {
            Vessel vessel =
                    new Vessel(
                            new VesselIdentity(
                                    (String)vesselLinkedHashMap.get("abbrVslM"),
                                    (String)vesselLinkedHashMap.get("inVoyN"),
                                    (String)vesselLinkedHashMap.get("shiftSeqN")
                            ),
                            (String) vesselLinkedHashMap.get("outVoyN"),
                            LocalDateTime.parse(
                                    (String)vesselLinkedHashMap.get("bthgDt"),
                                    formatter
                            ),
                            LocalDateTime.parse(
                                    (String)vesselLinkedHashMap.get("unbthgDt"),
                                    formatter
                            ),
                            (String) vesselLinkedHashMap.get("berthN"),
                            (String) vesselLinkedHashMap.get("status"));
            return vessel;
        } catch (DateTimeParseException pe) {
            return null;
        }
    }
}
