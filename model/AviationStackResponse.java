package com.example.airtravelwebapp.model;

import java.util.List;

/**
 * Represents the response from the AviationStack API.
 */
public class AviationStackResponse {
    private Pagination pagination; // Pagination information for the response
    private List<FlightData> data; // List of flight data

    // Getters and setters

    /**
     * Gets the pagination information for the response.
     * @return the pagination information
     */
    public Pagination getPagination() {
        return pagination;
    }

    /**
     * Sets the pagination information for the response.
     * @param pagination the pagination information
     */
    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    /**
     * Gets the list of flight data.
     * @return the list of flight data
     */
    public List<FlightData> getData() {
        return data;
    }

    /**
     * Sets the list of flight data.
     * @param data the list of flight data
     */
    public void setData(List<FlightData> data) {
        this.data = data;
    }
}