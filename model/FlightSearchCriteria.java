package com.example.airtravelwebapp.model;

/**
 * Represents the search criteria for finding flights.
 */
public class FlightSearchCriteria {
    private String startLocation; // The starting location for the flight search
    private String endLocation; // The ending location for the flight search
    private String travelDate; // The travel date for the flight search
    private int numTravelers; // The number of travelers for the flight search

    // Getters and setters

    /**
     * Gets the starting location for the flight search.
     * @return the starting location
     */
    public String getStartLocation() {
        return startLocation;
    }

    /**
     * Sets the starting location for the flight search.
     * @param startLocation the starting location
     */
    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    /**
     * Gets the ending location for the flight search.
     * @return the ending location
     */
    public String getEndLocation() {
        return endLocation;
    }

    /**
     * Sets the ending location for the flight search.
     * @param endLocation the ending location
     */
    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    /**
     * Gets the travel date for the flight search.
     * @return the travel date
     */
    public String getTravelDate() {
        return travelDate;
    }

    /**
     * Sets the travel date for the flight search.
     * @param travelDate the travel date
     */
    public void setTravelDate(String travelDate) {
        this.travelDate = travelDate;
    }

    /**
     * Gets the number of travelers for the flight search.
     * @return the number of travelers
     */
    public int getNumTravelers() {
        return numTravelers;
    }

    /**
     * Sets the number of travelers for the flight search.
     * @param numTravelers the number of travelers
     */
    public void setNumTravelers(int numTravelers) {
        this.numTravelers = numTravelers;
    }
}