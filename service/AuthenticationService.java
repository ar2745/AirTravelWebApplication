package com.example.airtravelwebapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.airtravelwebapp.model.User;
import com.example.airtravelwebapp.repository.UserRepository;
import com.example.airtravelwebapp.util.XMLUtil;

/**
 * Service class for handling authentication-related operations.
 */
@Service
public class AuthenticationService {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class); // Logger for logging messages
    private static final String XML_FILE_PATH = "C:/Users/ar274/Desktop/SNHU/IT-634/airtravelwebapp/src/main/resources/users.xml"; // Path to the XML file containing user data
    private final UserRepository userRepository; // User repository for database operations
    private final PasswordEncoder passwordEncoder; // Password encoder for encoding and matching passwords

    /**
     * Constructor for AuthenticationService.
     * Initializes the user list by reading from the XML file and encoding passwords if necessary.
     */
    @Autowired
    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
        initializeUsers();
    }

    /**
     * Initializes the user list by reading from the XML file and encoding passwords if necessary.
     */
    public void initializeUsers() {
        try {
            List<User> users = XMLUtil.readUsersFromXML(XML_FILE_PATH);
            for (User user : users) {
                if (!user.getPassword().startsWith("$2a$")) {
                    user.setPassword(passwordEncoder.encode(user.getPassword()));
                }
                userRepository.save(user);
            }
        } catch (Exception e) {
            logger.error("Error initializing users from XML", e);
        }
    }

    /**
     * Authenticates a user by username and password.
     * 
     * @param username the username of the user
     * @param password the password of the user
     * @return true if authentication is successful, false otherwise
     */
    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            logger.info("User authenticated: {}", username);
            return true;
        }
        logger.warn("Authentication failed for user: {}", username);
        return false;
    }

    /**
     * Finds a user by username.
     * 
     * @param username the username of the user
     * @return the User object if found, null otherwise
     */
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}