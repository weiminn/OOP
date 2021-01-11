package com.smuxoopg1t2.services;

import com.smuxoopg1t2.model.User;
import com.smuxoopg1t2.repository.IUserRepository;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;

/**
 * @Service marks a Java class that performs some service, such as executing
 * business logic, performing calculations, and calling external APIs. This
 * annotation is a specialized form of the @Component annotation intended to be
 * used in the service layer.
 */
@Service
public class UserService {

    /**
     * @Autowired is used to mark a dependency which Spring is going to resolve
     * and inject automatically.
     */
    @Autowired
    IUserRepository userRepository;

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    public User getUser(int id) {
        return userRepository.findById(id);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * Checks to see if the password entered by user in the frontend is valid or
     * not
     *
     * @param id          the user id
     * @param oldPassword the password that the user wants to reset
     * @return true or false if the password is entered matches
     */
    public boolean isUserPasswordValid(int id, String oldPassword) {
        User user = userRepository.findById(id);
        boolean passwordsMatch = BCrypt.checkpw(oldPassword,
                user.getHashedPassword());

        if (passwordsMatch) {
            return true;
        }
        return false;
    }

    /**
     * One of the two Overloaded methods to reset the users password.
     * This method is used if the user has forgotten the password
     *
     * @param email       the user's email
     * @param newPassword the new password requested by user to be set
     */
    public void resetPassword(String email, String newPassword) {
        User user = userRepository.findByEmail(email);
        user.setPassword(newPassword);
        userRepository.save(user);
    }

    /**
     * One of the two Overloaded methods to reset the users password.
     * This method is used if the user is logged in and wants to change his/her
     * password.
     *
     * @param userID      the user id
     * @param newPassword the new password requested by user to be set
     */
    public void resetPassword(int userID, String newPassword) {
        User user = userRepository.findById(userID);
        user.setPassword(newPassword);
        userRepository.save(user);
    }

    /**
     * Adding a new user into the database
     *
     * @param email    the email used by the user
     * @param password the users password
     * @param name     the users name
     * @return a LinkedHashMap containing the key result and the value true or
     * false. Additionally if true also returns the key user and value user
     * object
     */
    public LinkedHashMap addUser(String email, String password, String name) {
        LinkedHashMap<String, Object> toReturn = new LinkedHashMap();
        toReturn.put("result", Boolean.FALSE);

        User user = userRepository.findByEmail(email);
        if (user == null) {
            User newUser = new User();

            newUser.setEmail(email);
            newUser.setName(name);
            newUser.setPassword(password);

            userRepository.save(newUser);

            toReturn.put("result", Boolean.TRUE);
            toReturn.put("user", user);

            return toReturn;

        } else {
            return toReturn;
        }
    }
}
