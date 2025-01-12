package com.example.airtravelwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.airtravelwebapp.model.User;

/**
 * Repository interface for accessing User data from the database.
 * Extends JpaRepository to provide CRUD operations and custom query methods.
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {
    
    /**
     * Finds a User by their username.
     * @param username the username of the User
     * @return the User with the specified username, or null if no User found
     */
    User findByUsername(String username);
}