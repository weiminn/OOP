package com.smuxoopg1t2.controller;

import com.smuxoopg1t2.model.User;
import com.smuxoopg1t2.repository.IUserRepository;
import com.smuxoopg1t2.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.smuxoopg1t2.model.JwtRequest;
import com.smuxoopg1t2.model.JwtResponse;
import com.smuxoopg1t2.services.EmailService;
import com.smuxoopg1t2.config.JwtTokenUtil;
import com.smuxoopg1t2.services.JwtUserDetailsService;

//CrossOrigin RequestMapping RequestMethod RequestParam
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@CrossOrigin
public class JwtAuthenticationController {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUserDetailsService userDetailsService;
    
    @Autowired
    private EmailService emailService;

    @Value("${ip.address}")
    private String address;

    @Value("${server.port}")
    private String port;

    /**
     * Post request endpoint to authenticate user
     * @param authenticationRequest JwtRequest that stores email and password
     * @return ReponseEntity with status OK
     */
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(
            JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(),
                authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(
                authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    /**
     * private method to authenticate User
     * @param username Email of User
     * @param password Password of User
     * @throws Exception when invalid credentials provided
     */
    private void authenticate(String username, String password)
            throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    /**
     * Authenticate User (Web)
     * @param username Email of User
     * @param password Password of User
     * @param session HttpSession used to store data to render in thymeleaf
     * @param redirAttrs non-persistent store to render data in thymeleaf
     * @return redirect locations
     */
    @RequestMapping(value = "/authWeb", method = RequestMethod.POST)
    public String authenticateWeb(@RequestParam String username,
                       @RequestParam String password,
                       HttpSession session,
                       RedirectAttributes redirAttrs) {
        User user = userRepository.findByEmail(username);

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username,password));

            final UserDetails userDetails =
                    userDetailsService.loadUserByUsername(username);

            final String token = jwtTokenUtil.generateToken(userDetails);

            session.setAttribute("token", token);
            session.setAttribute("name", user.getName());
            session.setAttribute("id", user.getId());
            return "redirect:/dashboard";

        } catch (DisabledException | BadCredentialsException e) {
            redirAttrs.addFlashAttribute(
                    "formError","Invalid email/password");
            return "redirect:/login";
        }
    }

    /**
     * Post request to reset password
     * @param email Email of User
     * @param redirAttrs non-persistent store to render data in thymeleaf
     * @return redirect locations
     */
    @RequestMapping(path="/sendingResetLinkToEmail", method = RequestMethod.POST)
    public String sendingResetLinkToEmail (@RequestParam String email,
                                           RedirectAttributes redirAttrs) {
        User user = userService.getUserByEmail(email);

        // If user By-passes front end check, server should also ensure that
        // email is not empty
        if(email.equals("")){
            redirAttrs.addFlashAttribute(
                    "formError", "Email cannot be empty");
            return "redirect:/resetPassword";
        }

        if(user == null){
            redirAttrs.addFlashAttribute(
                    "formError", "Email does not exist");
            return "redirect:/resetPassword";
        }

        final UserDetails userDetails =
                userDetailsService.loadUserByUsername(email);

        final String token = jwtTokenUtil.generateToken(userDetails);

        String message = "<body><h1><b>Hi "+ user.getName() + ",</b></h1><br>";
        message += "You have requested to reset your password for your " +
                   "VesselScheduler Account.<br>";
        message += "<a href=\"http://"+address+":"+port+"/passwordUpdate?" +
                "Authorization=Bearer+" + token + "\">" +
                "<button>Reset Your Password</button></a><br>";
        message += "If you did not request a password reset, please ignore " +
                "this email.<br>";
        message += "The password reset is valid for 5 hours.<br><br>";
        message += "Best Regards,<br>";
        message += "VesselSchedulerTeam</body>";

        String[] mail = {email};
        emailService.sendFromGMail(mail,"Vessel Schedule Password Reset",
                message);

        return "redirect:/postResetPassword";
    }
}