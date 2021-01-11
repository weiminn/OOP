package com.smuxoopg1t2.services;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.AddressException;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Service marks a Java class that performs some service, such as executing
 * business logic, performing calculations, and calling external APIs. This
 * annotation is a specialized form of the @Component annotation intended to be
 * used in the service layer.
 */
@Service
public class EmailService {

    private static final Logger log =
            LoggerFactory.getLogger(EmailService.class);

    @Value("${mail.smtp.host}")
    private String host;
    
    @Value("${mail.smtp.port}")
    private String port;
    
    @Value("${mail.smtp.user}")
    private String from;
    
    @Value("${mail.smtp.password}")
    private String pass;

    /**
     * Send email to user
     *
     * @param to      a String array of user emails to be sending the email to
     * @param subject the subject of the email
     * @param body    the body of the email
     */
    public <MessagingException> void sendFromGMail(String[] to,
                                                          String subject,
                                                          String body) {


        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for (int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setContent(body, "text/html; charset=utf-8");
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            log.info("Sent notification to " + to.length + " users");
        } catch (AddressException ae) {
            ae.printStackTrace();
        } catch (javax.mail.MessagingException me) {
            me.printStackTrace();
        }
    }
}