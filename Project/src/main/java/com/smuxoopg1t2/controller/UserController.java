package com.smuxoopg1t2.controller;

import java.util.*;

import com.smuxoopg1t2.model.User;
import com.smuxoopg1t2.config.JwtTokenUtil;
import com.smuxoopg1t2.services.UserService;
import com.smuxoopg1t2.services.SystemConfigService;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private SystemConfigService systemConfigService;

    /**
     * Post request to register user
     * @param email
     * @param password
     * @param cfmPassword
     * @param name
     * @param redirAttrs
     * @return "redirect:/register"
     */
    @RequestMapping(path="/registrationWeb", method = RequestMethod.POST)
    public String registrationWeb(@RequestParam String email,
                                  @RequestParam String password,
                                  @RequestParam String cfmPassword,
                                  @RequestParam String name,
                                  RedirectAttributes redirAttrs) {
        // logic to change if the email is authorised
        if (! password.equals(cfmPassword)){
            redirAttrs.addFlashAttribute(
                    "formError", "Passwords does not match");
            return "redirect:/register";
        }

        boolean isAuthorised = systemConfigService.checkAuthorisedEmail(email);
        if (! isAuthorised){
            redirAttrs.addFlashAttribute(
                    "formError", "Unauthorised email domain");
            return "redirect:/register";
        }


        Map res = userService.addUser(email, password, name);

        if((Boolean) res.get("result")){
            String message = String.format(
                    "Successfully created new user, %s!", name);
            redirAttrs.addFlashAttribute("formSuccess", message );
            return "redirect:/login";
        } else {
            redirAttrs.addFlashAttribute(
                    "formError", "Error Creating User");
            return "redirect:/register";
        }
    }

    /**
     * Get Valid User Email Domains
     * @return String of email domains
     */
    @RequestMapping(path="/emailPlaceholders")
    public @ResponseBody String emailPlaceholders () {
        return systemConfigService.getCurrentValidEmailDomains();
    }

    
    /**
     * Post request to check existing email
     * @return "-1" | "1" 
     */
    @RequestMapping(path="/asyncEmailChecker", method = RequestMethod.POST)
    public @ResponseBody String asyncEmailChecker (@RequestParam String email) {
        User user = userService.getUserByEmail(email);
        String result = (user == null) ? "-1" : "1";
        return result;
    }

    /**
     * Post request to check previous password before updating to new password
     * @param userID
     * @param oldPassword
     * @return "-1" | "1" 
     */
    @RequestMapping(path="/asyncOldPasswordChecker", method = RequestMethod.POST)
    public @ResponseBody String asyncOldPasswordChecker (
            @RequestParam String userID, @RequestParam String oldPassword) {
        String result = userService
                .isUserPasswordValid(Integer.parseInt(userID), oldPassword)
                ? "1"
                : "-1";
        return result;
    }


    /**
     * Post request to reset password
     * @param token
     * @param password
     * @param cfmPassword
     * @param redirAttrs
     * @return redirect url
     */
    @RequestMapping(path="/updatePassword", method = RequestMethod.POST)
    public String updatePassword ( @RequestParam String token,
                                   @RequestParam String password,
                                   @RequestParam String cfmPassword,
                                   RedirectAttributes redirAttrs) {
        //@RequestParam(value = "token", required = false) String token

        // If there is not token provided redirect user back to login
        if(token == ""  || token == null){
            return "redirect:/login";
        }

        // If user By-passes front end check, server should also ensure both
        // passwords are not empty
        if(password.equals("") || cfmPassword.equals("")){
            redirAttrs.addFlashAttribute(
                    "formError", "Password cannot be empty");
            return "redirect:/passwordUpdate?Authorization=Bearer+"+token;
        }

        // If user By-passes front end check, server should also ensure both
        // passwords match
        if( !password.equals(cfmPassword) ){
            redirAttrs.addFlashAttribute(
                    "formError", "Passwords do not match");
            return "redirect:/passwordUpdate?Authorization=Bearer+"+token;
        }

        final String jwtToken = token;
        String username = jwtTokenUtil.getUsernameFromToken(jwtToken);
        userService.resetPassword(username, password);

        redirAttrs.addFlashAttribute(
                "formSuccess", "Password Reset Successful");
        return "redirect:/login";
    }

    /**
     * Post request to update password
     * @param userID
     * @param oldPassword
     * @param newPassword
     * @param cfmNewPassword
     * @param redirAttrs
     * @return redirect url
     */
    @RequestMapping(path="/loggedInUpdatePassword", method = RequestMethod.POST)
    public String loggedInUpdatePassword ( @RequestParam String userID,
                                           @RequestParam String oldPassword,
                                           @RequestParam String newPassword,
                                           @RequestParam String cfmNewPassword,
                                           RedirectAttributes redirAttrs) {

        // If user By-passes front end check, server should also ensure all
        // passwords fields are not empty
        if(oldPassword.equals("")
                || newPassword.equals("")
                || cfmNewPassword.equals("")){
            redirAttrs.addFlashAttribute(
                    "formError", "Please fill in all 3 fields");
            return "redirect:/resetPasswordLoggedIn";
        }

        // If user By-passes front end check, server should also ensure both
        // passwords match
        if( !newPassword.equals(cfmNewPassword) ){
            redirAttrs.addFlashAttribute(
                    "formError", "Passwords do not match");
            return "redirect:/resetPasswordLoggedIn";
        }

        // If user By-passes front end check, server should also ensure old
        // Password is Valid
        if(asyncOldPasswordChecker(userID,oldPassword).equals("-1")){
            redirAttrs.addFlashAttribute(
                    "formError", "Invalid OLD password");
            return "redirect:/resetPasswordLoggedIn";
        }

        // If user By-passes front end check, server should also ensure old and
        // new passwords don't match
        if(oldPassword.equals(newPassword)){
            redirAttrs.addFlashAttribute(
                    "formError", "Old and New Password cannot be the same");
            return "redirect:/resetPasswordLoggedIn";
        }

        userService.resetPassword(Integer.parseInt(userID), newPassword);

        redirAttrs.addFlashAttribute(
                "formSuccess", "Password Reset Successful");
        return "redirect:/resetPasswordLoggedIn";
    }

}
