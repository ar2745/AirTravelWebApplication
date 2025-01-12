package com.example.airtravelwebapp.model;

/**
 * Model class representing a flight search request.
 */
public class FlightSearchRequest {
    // The starting location for the flight search
    private String startLocation;
    
    // The ending location for the flight search
    private String endLocation;
    
    // The travel date for the flight search
    private String travelDate;
    
    // The number of travelers for the flight search
    private int numTravelers;

    // Getters and Setters

    /**
     * Gets the starting location.
     * 
     * @return the starting location
     */
    public String getStartLocation() {
        return startLocation;
    }

    /**
     * Sets the starting location.
     * 
     * @param startLocation the starting location to set
     */
    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    /**
     * Gets the ending location.
     * 
     * @return the ending location
     */
    public String getEndLocation() {
        return endLocation;
    }

    /**
     * Sets the ending location.
     * 
     * @param endLocation the ending location to set
     */
    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    /**
     * Gets the travel date.
     * 
     * @return the travel date
     */
    public String getTravelDate() {
        return travelDate;
    }

    /**
     * Sets the travel date.
     * 
     * @param travelDate the travel date to set
     */
    public void setTravelDate(String travelDate) {
        this.travelDate = travelDate;
    }

    /**
     * Gets the number of travelers.
     * 
     * @return the number of travelers
     */
    public int getNumTravelers() {
        return numTravelers;
    }

    /**
     * Sets the number of travelers.
     * 
     * @param numTravelers the number of travelers to set
     */
    public void setNumTravelers(int numTravelers) {
        this.numTravelers = numTravelers;
    }
}