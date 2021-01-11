package com.smuxoopg1t2.services;

import java.util.ArrayList;

import com.smuxoopg1t2.repository.IUserRepository;
import com.smuxoopg1t2.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * @Service marks a Java class that performs some service, such as executing
 * business logic, performing calculations, and calling external APIs. This
 * annotation is a specialized form of the @Component annotation intended to be
 * used in the service layer.
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

    /**
     * @Autowired is used to mark a dependency which Spring is going to resolve
     * and inject automatically.
     */
    @Autowired
    private IUserRepository userRepository;

    /**
     * loadUserByUsername is Overridden from the UserDetailService. This method
     * is used to validate if the username entered is valid or not
     *
     * @param username the username entered
     * @return the UserDetails if found or UsernameNotFoundException if not
     * found
     */
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username:"+
                    username);
        }
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getHashedPassword(), new ArrayList<>());
    }
}

