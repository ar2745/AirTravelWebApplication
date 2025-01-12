package com.example.airtravelwebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.airtravelwebapp.model.User;
import com.example.airtravelwebapp.service.AuthenticationService;

/**
 * REST controller for handling authentication-related requests.
 */
@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService; // Service for handling authentication logic

    /**
     * Endpoint for user login.
     * 
     * @param user the user object containing username and password
     * @return a message indicating whether the login was successful or if the credentials are invalid
     */
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        boolean isAuthenticated = authenticationService.authenticate(user.getUsername(), user.getPassword());
        if (isAuthenticated) {
            return "Login successful";
        } else {
            return "Invalid credentials";
        }
    }
}