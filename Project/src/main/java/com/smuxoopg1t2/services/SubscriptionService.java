package com.smuxoopg1t2.services;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.*;

import com.smuxoopg1t2.model.User;
import com.smuxoopg1t2.model.Vessel;
import com.smuxoopg1t2.model.VesselIdentity;
import com.smuxoopg1t2.repository.IUserRepository;
import com.smuxoopg1t2.repository.IVesselRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Service marks a Java class that performs some service, such as executing
 * business logic, performing calculations, and calling external APIs. This
 * annotation is a specialized form of the @Component annotation intended to be
 * used in the service layer.
 */
@Service
public class SubscriptionService {

    /**
     * @Autowired is used to mark a dependency which Spring is going to resolve
     * and inject automatically.
     */
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IVesselRepository vesselRepository;

    @Autowired
    public SubscriptionService() {
    }

    private static final Logger log =
            LoggerFactory.getLogger(ScheduleService.class);

    /**
     * Retrieve all Vessel Object that user has subscribed to via key value
     * pairs
     *
     * @param userId the users user id
     * @return vesselJson the list of Vessel objects from the Subscription
     * table returned as a String
     */
    public String getSubByUserId(int userId) {
        try {
            User user = userRepository.findById(userId);

            log.info("Retrieved User inside service: " + user.getId());

            ObjectMapper mapper = new ObjectMapper();
            Iterable<Vessel> sub = user.getSubscriptions();
            ArrayList<Map> subList = new ArrayList<>();

            for (Vessel vessel : sub) {
                Map<String, Object> vesselMap = vessel.toHashedMap();
                subList.add(vesselMap);
            }

            String vesselJson = mapper.writeValueAsString(subList);
            return vesselJson;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    /**
     * Retrieve all User Objects that subscribed for a vessel
     *
     * @param vesselName     the name of the vessel
     * @param incomingVoyage the incoming voyage of the vessel
     * @param shiftSeqN      the shift sequence of the vessel
     * @return a set of User objects that have subscribed to a particular
     * vessel from the subscription table
     */
    public Set<User> getSubByVesselId(String vesselName, String incomingVoyage,
                                      String shiftSeqN) {
        Optional<Vessel> optionalVessel = vesselRepository.findById(
                new VesselIdentity(vesselName, incomingVoyage, shiftSeqN));

        if (optionalVessel.isPresent()) {
            Vessel vessel = optionalVessel.get();
            return vessel.getSubscribedBy();
        }
        return null;
    }

    /**
     * Creates a new Subscription Object for user
     *
     * @param userId         the users user id
     * @param incomingVoyage the incoming voyage of the vessel
     * @param vesselName     the name of the vessel
     * @param shiftSeqN      the shift sequence of the vessel
     * @return "Saved" if successful and the error message if false
     */
    public String createSub(int userId, String incomingVoyage, String vesselName,
                            String shiftSeqN) {
        User user = userRepository.findById(userId);
        try {
            Optional<Vessel> optionalVessel = vesselRepository.findById(
                    new VesselIdentity(vesselName, incomingVoyage, shiftSeqN));

            Vessel subVessel = optionalVessel.get();

            //retrieve the favourites object and add the new vessel in
            user.getSubscriptions().add(subVessel);
            subVessel.getSubscribedBy().add(user);

            userRepository.save(user);
            vesselRepository.save(subVessel);
            return "Saved";

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    /**
     * Remove user's subscribed vessel
     *
     * @param userId         the users user id
     * @param incomingVoyage the incoming voyage of the vessel
     * @param vesselName     the name of the vessel
     * @param shiftSeqN      the shift sequence of the vessel
     * @return "Deleted" if successful and the error message if false
     */

    public String removeSub(int userId, String incomingVoyage,
                            String vesselName, String shiftSeqN) {
        User user = userRepository.findById(userId);
        try {
            Optional<Vessel> optionalVessel = vesselRepository.findById(
                    new VesselIdentity(vesselName, incomingVoyage, shiftSeqN));
            Vessel subVessel = optionalVessel.get();

            //retrieve the subscribed object and add the new vessel in
            user.getSubscriptions().remove(subVessel);
            subVessel.getSubscribedBy().remove(user);

            userRepository.save(user);
            vesselRepository.save(subVessel);

            return "Deleted";

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }
}
