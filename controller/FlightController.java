package com.example.airtravelwebapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.airtravelwebapp.model.Flight;
import com.example.airtravelwebapp.model.FlightSearchCriteria;
import com.example.airtravelwebapp.service.FlightService;

/**
 * REST controller for handling flight-related requests.
 */
@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private static final Logger logger = LoggerFactory.getLogger(FlightController.class);

    private final FlightService flightService;

    /**
     * Constructor for FlightController.
     * 
     * @param flightService the service to handle flight operations
     */
    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    /**
     * Endpoint to get all flights.
     * 
     * @return a ResponseEntity containing a list of all flights
     */
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        logger.info("Fetching all flights");
        List<Flight> flights = flightService.getAllFlights();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    /**
     * Endpoint to search for flights based on criteria.
     * 
     * @param searchCriteria the search criteria
     * @return a ResponseEntity containing a list of matching flights
     */
    @PostMapping("/search")
    public ResponseEntity<List<Flight>> searchFlights(@RequestBody FlightSearchCriteria searchCriteria) {
        logger.info("Searching for flights with criteria: {}", searchCriteria);

        List<Flight> flights = flightService.searchFlights(searchCriteria);
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    /**
     * Endpoint to get a flight by its ID.
     * 
     * @param id the ID of the flight
     * @return a ResponseEntity containing the Flight object with the specified ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id) {
        logger.info("Fetching flight with ID: {}", id);
        Flight flight = flightService.getFlightById(id);
        if (flight == null) {
            logger.error("Flight with ID: {} not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    /**
     * Endpoint to create a new flight.
     * 
     * @param flight the Flight object to be created
     * @return a ResponseEntity containing the created Flight object
     */
    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        logger.info("Creating new flight");
        Flight createdFlight = flightService.createFlight(flight);
        return new ResponseEntity<>(createdFlight, HttpStatus.CREATED);
    }

    /**
     * Endpoint to update an existing flight.
     * 
     * @param id the ID of the flight to be updated
     * @param flight the Flight object with updated details
     * @return a ResponseEntity containing the updated Flight object
     */
    @PutMapping("/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Long id, @RequestBody Flight flight) {
        logger.info("Updating flight with ID: {}", id);
        Flight updatedFlight = flightService.updateFlight(id, flight);
        if (updatedFlight == null) {
            logger.error("Flight with ID: {} not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedFlight, HttpStatus.OK);
    }

    /**
     * Endpoint to delete a flight by its ID.
     * 
     * @param id the ID of the flight to be deleted
     * @return a ResponseEntity with the appropriate HTTP status
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        logger.info("Deleting flight with ID: {}", id);
        boolean isDeleted = flightService.deleteFlight(id);
        if (!isDeleted) {
            logger.error("Flight with ID: {} not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}