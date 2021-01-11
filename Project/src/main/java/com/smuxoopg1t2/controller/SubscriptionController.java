package com.smuxoopg1t2.controller;

import com.smuxoopg1t2.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/subscriptions")
public class SubscriptionController {

    @Autowired
    SubscriptionService subscriptionService;


    /**
     * Post request endpoint to subscribe to vessel
     * @param userID
     * @param incoming_voyage
     * @param vessel
     * @param shiftSeqN
     * @return "Saved"
     */
    @PostMapping(path="/addSub")
    public @ResponseBody
    String addSubscription(@RequestParam int userID,
                        @RequestParam String incoming_voyage,
                        @RequestParam String vessel,
                        @RequestParam String shiftSeqN){

        String res = subscriptionService.createSub(userID, incoming_voyage,
                vessel, shiftSeqN);
        return res;
    }

    
    /**
     * Post request endpoint to unsubscribe to vessel
     * @param userID
     * @param incoming_voyage
     * @param vessel
     * @param shiftSeqN
     * @return "Deleted"
     */
    @PostMapping(path="/removeSub")
    public @ResponseBody
    String removeSubscription(@RequestParam int userID,
                        @RequestParam String incoming_voyage,
                        @RequestParam String vessel,
                        @RequestParam String shiftSeqN){

        String res = subscriptionService.removeSub(userID, incoming_voyage,
                vessel, shiftSeqN);
        return res;
    }

    /**
     * Get request endpoint to get all subscribed vessels
     * @param userID
     * @return JSON array of vessel objects
     */
    @GetMapping(path="/{id}")
    public @ResponseBody String getSubscriptionById(
            @PathVariable("id") String userID) {
        // This returns a JSON or XML with the users
        String subscriptions = subscriptionService.getSubByUserId(
                Integer.parseInt(userID));
        return subscriptions;
    }


}
