package com.example.airtravelwebapp.config;

import static org.springframework.security.config.Customizer.*;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.airtravelwebapp.model.User;
import com.example.airtravelwebapp.service.AuthenticationService;

/**
 * Security configuration class for the application.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final AuthenticationService authenticationService;

    /**
     * Constructor to inject the AuthenticationService.
     * 
     * @param authenticationService the authentication service
     */
    public SecurityConfig(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    /**
     * Configures the security filter chain.
     * 
     * @param http the HttpSecurity object to configure
     * @return the configured SecurityFilterChain
     * @throws Exception if an error occurs during configuration
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Enable CSRF protection with cookies
            .csrf(csrf -> csrf.disable())
            // Configure authorization rules
            .authorizeHttpRequests(authorize -> authorize
                // Allow unauthenticated access to registration and authentication endpoints
                .requestMatchers("/api/users/register", "/api/users/authenticate", "/api/flights/search").permitAll()
                // Require authentication for all other requests
                .anyRequest().authenticated()
            )
            // Enable HTTP Basic authentication
            .httpBasic(withDefaults());
        return http.build();
    }

    /**
     * Bean for password encoding using BCrypt.
     * 
     * @return the PasswordEncoder bean
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Bean for user details service.
     * 
     * @return the UserDetailsService bean
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            // Find the user by username
            User user = authenticationService.findByUsername(username);
            if (user == null) {
                // Throw exception if user is not found
                throw new UsernameNotFoundException("User not found");
            }
            // Return a UserDetails object with the user's information
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
        };
    }
}