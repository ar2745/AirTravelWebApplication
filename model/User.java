package com.example.airtravelwebapp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Model class representing a user in the air travel web application.
 * This class is annotated for JPA and XML serialization and deserialization.
 */
@Entity
@XmlRootElement(name = "user")
public class User {
    @Id
    private String username; // The username of the user
    private String password; // The password of the user

    /**
     * Gets the username of the user.
     * 
     * @return the username
     */
    @XmlElement
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     * 
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password of the user.
     * 
     * @return the password
     */
    @XmlElement
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     * 
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}