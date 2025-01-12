package com.example.airtravelwebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.airtravelwebapp.model.User;
import com.example.airtravelwebapp.service.UserService;

/**
 * REST controller for handling user-related requests.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Endpoint to register a new user.
     * 
     * @param username the username of the new user
     * @param password the password of the new user
     * @return a message indicating whether the registration was successful or if the username already exists
     */
    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        boolean isRegistered = userService.registerUser(user);
        return isRegistered ? "Registration successful" : "Username already exists";
    }

    /**
     * Endpoint to authenticate a user.
     * 
     * @param username the username of the user
     * @param password the password of the user
     * @return a message indicating whether the authentication was successful or if the credentials are invalid
     */
    @PostMapping("/authenticate")
    public String authenticateUser(@RequestParam String username, @RequestParam String password) {
        boolean isAuthenticated = userService.authenticateUser(username, password);
        return isAuthenticated ? "Authentication successful" : "Invalid username or password";
    }
}