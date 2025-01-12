package com.example.airtravelwebapp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model class representing a flight search response.
 */
public class FlightSearchResponse {
    // Message to be included in the flight search response
    private String message;


    // List of flights matching the search criteria
    @JsonProperty("data")
    private List<Flight> flights;

    // Getters and Setters

    /**
     * Gets the message.
     * 
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     * 
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the list of flights.
     * 
     * @return the list of flights
     */
    public List<Flight> getFlights() {
        return flights;
    }

    /**
     * Sets the list of flights.
     * 
     * @param flights the list of flights to set
     */
    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    // Optional: Constructor to initialize fields

    /**
     * Constructor to initialize the message and flights.
     * 
     * @param message the message to set
     * @param flights the list of flights to set
     */
    public FlightSearchResponse(String message, List<Flight> flights) {
        this.message = message;
        this.flights = flights;
    }

    // Default constructor
    public FlightSearchResponse() {
    }
}