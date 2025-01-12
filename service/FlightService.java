package com.example.airtravelwebapp.service;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.airtravelwebapp.model.AviationStackResponse;
import com.example.airtravelwebapp.model.Flight;
import com.example.airtravelwebapp.model.FlightData;
import com.example.airtravelwebapp.model.FlightSearchCriteria;
import com.example.airtravelwebapp.repository.FlightRepository;

/**
 * Service class for handling flight-related operations.
 */
@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository; // Repository for Flight entities

    @Autowired
    private RestTemplate restTemplate; // RestTemplate for making HTTP requests

    private static final String API_URL = "http://api.aviationstack.com/v1/flights";
    private static final String ACCESS_KEY = "e55cd9938b6bcf1b79ff775182603c81"; // Replace with your actual access key

    /**
     * Retrieves all flights from the repository.
     * 
     * @return a list of all flights
     */
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    /**
     * Searches for flights based on the given criteria.
     * 
     * @param searchCriteria the criteria to search for flights
     * @return a list of flights matching the criteria
     */
    public List<Flight> searchFlights(FlightSearchCriteria searchCriteria) {
        return flightRepository.findByCriteria(searchCriteria);
    }

    /**
     * Retrieves a flight by its ID from the repository.
     * 
     * @param id the ID of the flight
     * @return the Flight object with the specified ID, or null if not found
     */
    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    /**
     * Creates a new flight and saves it to the repository.
     * 
     * @param flight the Flight object to be created
     * @return the created Flight object
     */
    public Flight createFlight(Flight flight) {
        setFormattedTimes(flight);
        return flightRepository.save(flight);
    }

    /**
     * Deletes a flight by its ID from the repository.
     * 
     * @param id the ID of the flight to be deleted
     * @return true if the flight was deleted, false otherwise
     */
    public boolean deleteFlight(Long id) {
        if (!flightRepository.existsById(id)) {
            return false;
        }
        flightRepository.deleteById(id);
        return true;
    }

    /**
     * Updates the details of an existing flight with the details from an updated flight.
     * 
     * @param flight the existing Flight object
     * @param updatedFlight the updated Flight object
     */
    private void updateFlightDetails(Flight flight, Flight updatedFlight) {
        flight.setFlightNumber(updatedFlight.getFlightNumber());
        flight.setOrigin(updatedFlight.getOrigin());
        flight.setDestination(updatedFlight.getDestination());
        flight.setDepartureTime(updatedFlight.getDepartureTime());
        flight.setArrivalTime(updatedFlight.getArrivalTime());
        flight.setPrice(updatedFlight.getPrice());
        flight.setAvailableSeats(updatedFlight.getAvailableSeats());
    }

    /**
     * Updates an existing flight in the repository.
     * 
     * @param id the ID of the flight to be updated
     * @param updatedFlight the Flight object with updated details
     * @return the updated Flight object, or null if the flight with the specified ID does not exist
     */
    public Flight updateFlight(Long id, Flight updatedFlight) {
        return flightRepository.findById(id).map(flight -> {
            updateFlightDetails(flight, updatedFlight);
            setFormattedTimes(flight);
            return flightRepository.save(flight);
        }).orElse(null);
    }

    /**
     * Sets the formatted departure and arrival times for a flight.
     * 
     * @param flight the Flight object
     */
    private void setFormattedTimes(Flight flight) {
        flight.setDepartureTime12HourFormat(formatTo12HourClock(flight.getDepartureTime()));
        flight.setArrivalTime12HourFormat(formatTo12HourClock(flight.getArrivalTime()));
    }

    /**
     * Fetches live flight data from the AviationStack API and stores it in the repository.
     */
    public void fetchAndStoreFlights() {
        String url = API_URL + "?access_key=" + ACCESS_KEY + "&limit=100"; // Adjust parameters as needed
        AviationStackResponse response = restTemplate.getForObject(url, AviationStackResponse.class);
        if (response != null && response.getData() != null) {
            for (FlightData flightData : response.getData()) {
                Flight flight = createFlightFromData(flightData);
                flightRepository.save(flight);
            }
        }
    }

    /**
     * Creates a Flight object from FlightData.
     * 
     * @param flightData the FlightData object
     * @return the created Flight object
     */
    private Flight createFlightFromData(FlightData flightData) {
        Flight flight = new Flight();
        flight.setFlightNumber(flightData.getFlight().getFlightNumber());
        flight.setOrigin(flightData.getDeparture().getIata());
        flight.setDestination(flightData.getArrival().getIata());
        
        // Parse and format departure and arrival times
        String departureTime = flightData.getDeparture().getScheduled();
        String arrivalTime = flightData.getArrival().getScheduled();
        
        flight.setDepartureTime(parseAndFormatDateTime(departureTime));
        flight.setArrivalTime(parseAndFormatDateTime(arrivalTime));
        flight.setDepartureTime12HourFormat(formatTo12HourClock(departureTime));
        flight.setArrivalTime12HourFormat(formatTo12HourClock(arrivalTime));
        
        flight.setPrice(100.0); // Set a default price or calculate based on your logic
        flight.setAvailableSeats(100); // Set a default number of available seats
        return flight;
    }

    /**
     * Parses and formats a date-time string.
     * 
     * @param dateTimeString the date-time string to parse and format
     * @return the formatted date-time string
     */
    private String parseAndFormatDateTime(String dateTimeString) {
        try {
            OffsetDateTime dateTime = OffsetDateTime.parse(dateTimeString, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
            return dateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Formats the given date-time string to a 12-hour clock format.
     * 
     * @param dateTimeString the date-time string to format
     * @return the formatted time in 12-hour clock format
     */
    private String formatTo12HourClock(String dateTimeString) {
        try {
            OffsetDateTime dateTime = OffsetDateTime.parse(dateTimeString, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a"); // Use single 'h' for hour without leading zero
            return dateTime.format(formatter);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}