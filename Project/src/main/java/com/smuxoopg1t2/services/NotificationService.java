package com.smuxoopg1t2.services;

import com.smuxoopg1t2.model.User;
import com.smuxoopg1t2.model.Vessel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.time.LocalDateTime;

@Service
public class NotificationService {

    @Autowired
    private EmailService emailService;


    /**
     * Sends the email to all the users who have subscribed to this particular
     * vessel showing the time previously and the time it has been updated to.
     *
     * @param users              A set of User objects that has subscribed to
     *                           this particular vessel
     * @param vessel             The vessel object that is pulled from the api
     *                           endpoint
     * @param lstUpdatedBrthTime the date and time of the vessel that is in the
     *                           database, and its last updated berth time not
     *                           found in the vesselObject
     */
    public void sendUpdatedNotification(Set<User> users, Vessel vessel,
                                               LocalDateTime lstUpdatedBrthTime) {
        String subject = "Updated Vessel Timing for " +
                vessel.getVesselIdentity().getName();

        LocalDateTime initialBerthTime = (lstUpdatedBrthTime == null)
                ? vessel.getBerthingTime()
                : lstUpdatedBrthTime;

        String body = "<p>Dear User</p>" +
                "<p>The vessel that you have subscribed to has changed " +
                "its timing from " + initialBerthTime + " to " +
                vessel.getUpdatedBerthingTime() + "</p>";

        int count = 0;
        String[] emails = new String[users.size()];
        for (User user : users) {
            emails[count] = user.getEmail();
            count++;
        }

        emailService.sendFromGMail(emails, subject, body);
    }
}
