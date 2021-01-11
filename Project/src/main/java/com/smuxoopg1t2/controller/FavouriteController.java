package com.smuxoopg1t2.controller;

import com.smuxoopg1t2.services.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/favourites")
public class FavouriteController {

    @Autowired
    FavouriteService favouriteService;

    /**
     * Post request endpoint to Add Vessel to favourites
     * @param userID id of user
     * @param incoming_voyage incoming voyage number
     * @param vessel Name of vessel
     * @param shiftSeqN Shift Sequence Number of Vessel
     * @return String res       "Saved"
     */
    @PostMapping(path="/addFav")
    public @ResponseBody
    String addFavourites(@RequestParam int userID,
                        @RequestParam String incoming_voyage,
                        @RequestParam String vessel,
                        @RequestParam String shiftSeqN){

        String res = favouriteService.createFav(userID, incoming_voyage, vessel,
                shiftSeqN);
        return res;
    }

    /**
     * Post request endpoint to Remove Vessel from favourites
     * @param userID id of user
     * @param incoming_voyage incoming voyage number
     * @param vessel Name of vessel
     * @param shiftSeqN Shift Sequence Number of Vessel
     * @return String res       "Deleted"
     */
    @PostMapping(path="/removeFav")
    public @ResponseBody
    String removeFavourite(@RequestParam int userID,
                        @RequestParam String incoming_voyage,
                        @RequestParam String vessel,
                        @RequestParam String shiftSeqN){
        String res = favouriteService.removeFav(userID, incoming_voyage, vessel,
                shiftSeqN);
        return res;
    }

    /**
     * Get request endpoint to get all favourited Vessel of user
     * @param userID id of user
     * @return JSON array of vessel objects
     */
    @GetMapping(path="/{id}")
    public @ResponseBody String getFavById(@PathVariable("id") String userID) {
        // This returns a JSON or XML with the users
        String favourites = favouriteService.getFav(Integer.parseInt(userID));
        return favourites;
    }
}
