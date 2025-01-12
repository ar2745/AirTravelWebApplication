package com.example.airtravelwebapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airtravelwebapp.model.Flight;
import com.example.airtravelwebapp.model.FlightSearchRequest;
import com.example.airtravelwebapp.model.FlightSearchResponse;
import com.example.airtravelwebapp.repository.FlightRepository;

/**
 * Service class for handling flight search operations.
 */
@Service
public class FlightSearchService {

    @Autowired
    private FlightRepository flightRepository; // Repository for Flight entities

    /**
     * Searches for flights based on the provided request.
     * 
     * @param request the flight search request containing search criteria
     * @return the flight search response with the search results
     */
    public FlightSearchResponse searchFlights(FlightSearchRequest request) {
        // Query the database for flights matching the search criteria
        List<Flight> flights = flightRepository.findByOriginAndDestinationAndDepartureTime(
                request.getStartLocation(), request.getEndLocation(), request.getTravelDate());

        // Create a response object and set the search results
        FlightSearchResponse response = new FlightSearchResponse();
        response.setFlights(flights);
        response.setMessage("Found " + flights.size() + " flights from " + request.getStartLocation() + " to "
                + request.getEndLocation() + " on " + request.getTravelDate() + " for " + request.getNumTravelers()
                + " travelers.");

        // Return the constructed response
        return response;
    }
}