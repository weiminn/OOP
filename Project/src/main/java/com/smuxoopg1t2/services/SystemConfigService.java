package com.smuxoopg1t2.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Service marks a Java class that performs some service, such as executing
 * business logic, performing calculations, and calling external APIs. This
 * annotation is a specialized form of the @Component annotation intended to be
 * used in the service layer.
 */
@Service
public class SystemConfigService {

    /**
     * @Value used for injecting values into fields in Spring-managed beans,
     * and it can be applied at the field or constructor/method parameter
     * level.
     * In this case, we will be using values from
     * resources/application.properties
     */
    @Value("${system.config.emailDomains}")
    private String emailDomains;

    /**
     * When the user registers for an account with us, do a serverside
     * validation to see if the email domain entered is valid.
     *
     * @param email the email entered by the user while registering for an
     *              account.
     * @return true or false based on if email domain entered is valid or not
     */
    public boolean checkAuthorisedEmail(String email) {
        String formEmailDomain = email.split("@")[1];
        boolean isAuthorised = emailDomains.contains(formEmailDomain);

        return isAuthorised;
    }

    /**
     * When the front-end page register.html is loaded, this method is called
     * to retrieve all valid email domains that are valid and returns a String
     * of valid domains.
     *
     * @return a String of valid domains taken from
     * resources/application.properties
     */
    public String getCurrentValidEmailDomains() {
        return this.emailDomains;
    }
}