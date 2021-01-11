package com.smuxoopg1t2.services;

import java.util.*;

import com.smuxoopg1t2.model.User;
import com.smuxoopg1t2.model.Vessel;
import com.smuxoopg1t2.repository.IUserRepository;
import com.smuxoopg1t2.repository.IVesselRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.*;

import com.smuxoopg1t2.model.VesselIdentity;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Service marks a Java class that performs some service, such as executing
 * business logic, performing calculations, and calling external APIs. This
 * annotation is a specialized form of the @Component annotation intended to be
 * used in the service layer.
 */
@Service
public class FavouriteService {
    /**
     * @Autowired is used to mark a dependency which Spring is going to resolve
     * and inject automatically.
     */
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IVesselRepository vesselRepository;

    @Autowired
    public FavouriteService() {
    }

    private static final Logger log =
            LoggerFactory.getLogger(ScheduleService.class);

    /**
     * Retrieve all Vessel Object that user has favourited from Favourites Table
     *
     * @param userId the user id
     * @return vesselJson the list of Vessel objects from the favourite
     * table returned as a String
     */
    public String getFav(int userId) {

        try {
            User user = userRepository.findById(userId);

            log.info("Retrieved User inside service: " + user.getId());

            ObjectMapper mapper = new ObjectMapper();
            Iterable<Vessel> fav = user.getFavourites();
            ArrayList<Map> favList = new ArrayList<>();

            for (Vessel vessel : fav) {
                Map<String, Object> vesselMap = vessel.toHashedMap();
                favList.add(vesselMap);
            }

            String vesselJson = mapper.writeValueAsString(favList);
            return vesselJson;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    /**
     * Creates a new Favourite Object and save it into the join table of User
     * and Vessel
     *
     * @param userId         the users user id
     * @param incomingVoyage the incoming voyage of the vessel
     * @param vesselName     the name of the vessel
     * @param shiftSeqN      the shift sequence of the vessel
     * @return "Saved" if successful and the error message if false
     */
    public String createFav(int userId, String incomingVoyage,
                            String vesselName, String shiftSeqN) {

        User user = userRepository.findById(userId);

        try {
            Optional<Vessel> optionalVessel = vesselRepository.findById(
                    new VesselIdentity(vesselName, incomingVoyage, shiftSeqN));
            Vessel favVessel = optionalVessel.get();

            //retrieve the favourites object and add the new vessel in
            user.getFavourites().add(favVessel);
            favVessel.getFavouritedBy().add(user);

            userRepository.save(user);
            vesselRepository.save(favVessel);

            return "Saved";

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    /**
     * Remove user's favourite Object from favourite table
     *
     * @param userId         the users user id
     * @param incomingVoyage the incoming voyage of the vessel
     * @param vesselName     the name of the vessel
     * @param shiftSeqN      the shift sequence of the vessel
     * @return "Deleted" if successful and the error message if false
     */

    public String removeFav(int userId, String incomingVoyage,
                            String vesselName, String shiftSeqN) {

        User user = userRepository.findById(userId);

        try {
            Optional<Vessel> optionalVessel = vesselRepository.findById(
                    new VesselIdentity(vesselName, incomingVoyage, shiftSeqN));
            Vessel favVessel = optionalVessel.get();

            //retrieve the favourites object and add the new vessel in
            user.getFavourites().remove(favVessel);
            favVessel.getFavouritedBy().remove(user);

            userRepository.save(user);
            vesselRepository.save(favVessel);

            return "Deleted";

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }
}
