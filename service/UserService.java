package com.example.airtravelwebapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.airtravelwebapp.model.User;
import com.example.airtravelwebapp.util.XMLUtil;

/**
 * Service class for handling user operations.
 */
@Service
public class UserService {
    private static final String XML_FILE_PATH = "C:/Users/ar274/Desktop/SNHU/IT-634/airtravelwebapp/src/main/resources/users.xml";

    /**
     * Registers a new user.
     * 
     * @param user the user to register
     * @return true if registration is successful, false otherwise
     */
    public boolean registerUser(User user) {
        // Read the list of users from the XML file
        List<User> users = XMLUtil.readUsersFromXML(XML_FILE_PATH);
        
        // Check if the username already exists
        for (User existingUser : users) {
            if (existingUser.getUsername().equals(user.getUsername())) {
                return false; // Username already exists
            }
        }
        
        // Add the new user to the list
        users.add(user);
        
        // Write the updated list of users back to the XML file
        XMLUtil.writeUsersToXML(users, XML_FILE_PATH);
        
        // Registration successful
        return true;
    }

    /**
     * Authenticates a user.
     * 
     * @param username the username
     * @param password the password
     * @return true if authentication is successful, false otherwise
     */
    public boolean authenticateUser(String username, String password) {
        // Read the list of users from the XML file
        List<User> users = XMLUtil.readUsersFromXML(XML_FILE_PATH);
        
        // Check if the username and password match any user in the list
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true; // Authentication successful
            }
        }
        
        // Authentication failed
        return false;
    }
}