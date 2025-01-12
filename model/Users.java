package com.example.airtravelwebapp.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Model class representing a collection of User objects.
 * This class is annotated for XML serialization and deserialization.
 */
@XmlRootElement(name = "users")
public class Users {
    private List<User> users; // List of User objects

    /**
     * Gets the list of User objects.
     * 
     * @return the list of users
     */
    @XmlElement(name = "user")
    public List<User> getUsers() {
        return users;
    }

    /**
     * Sets the list of User objects.
     * 
     * @param users the list of users to set
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }
}