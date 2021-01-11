package com.smuxoopg1t2.controller;

import com.smuxoopg1t2.services.VesselService;

//RestContoller, RequestMapping, GetMapping, PathVariable
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/vessel")
public class VesselController {
    @Autowired
    VesselService vesselService;

    /**
     * Post request to update password
     * @param date
     * @param userID
     * @return JSON array of vessel objects
     */
    @GetMapping(path="/date={date}&userID={userID}")
    public String retrieveVessels(@PathVariable("date") String date,
                                  @PathVariable("userID") int userID) {
        String vessels = vesselService.getAllVesselsByDate(date,userID);
        return vessels;
    }
}
