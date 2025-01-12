package com.example.airtravelwebapp.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entity class representing a flight.
 */
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String flightNumber;    // Flight number
    private String origin;          // Origin of the flight
    private String destination;     // Destination of the flight
    private String departureTime;   // Departure time
    private String arrivalTime;     // Arrival time
    private double price;           // Price of the flight
    private int availableSeats;     // Number of available seats
    private String departureTime12HourFormat;   // Departure time in 12-hour format
    private String arrivalTime12HourFormat;     // Arrival time in 12-hour format
    
    // Getters and Setters

    /**
     * Gets the ID of the flight.
     * 
     * @return the ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the flight.
     * 
     * @param id the ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the flight number.
     * 
     * @return the flight number
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * Sets the flight number.
     * 
     * @param flightNumber the flight number to set
     */
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    /**
     * Gets the origin of the flight.
     * 
     * @return the origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the origin of the flight.
     * 
     * @param origin the origin to set
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * Gets the destination of the flight.
     * 
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Sets the destination of the flight.
     * 
     * @param destination the destination to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * Gets the departure time of the flight.
     * 
     * @return the departure time
     */
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * Sets the departure time of the flight.
     * 
     * @param departureTime the departure time to set
     */
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * Gets the arrival time of the flight.
     * 
     * @return the arrival time
     */
    public String getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Sets the arrival time of the flight.
     * 
     * @param arrivalTime the arrival time to set
     */
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * Gets the price of the flight.
     * 
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the flight.
     * 
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the number of available seats.
     * 
     * @return the number of available seats
     */
    public int getAvailableSeats() {
        return availableSeats;
    }

    /**
     * Sets the number of available seats.
     * 
     * @param availableSeats the number of available seats to set
     */
    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    /**
     * Gets the departure time in 12-hour format.
     * 
     * @return the departure time in 12-hour format
     */
    public String getDepartureTime12HourFormat() {
        return departureTime12HourFormat;
    }

    /**
     * Sets the departure time in 12-hour format.
     * 
     * @param departureTime12HourFormat the departure time in 12-hour format to set
     */
    public void setDepartureTime12HourFormat(String departureTime12HourFormat) {
        this.departureTime12HourFormat = departureTime12HourFormat;
    }

    /**
     * Gets the arrival time in 12-hour format.
     * 
     * @return the arrival time in 12-hour format
     */
    public String getArrivalTime12HourFormat() {
        return arrivalTime12HourFormat;
    }

    /**
     * Sets the arrival time in 12-hour format.
     * 
     * @param arrivalTime12HourFormat the arrival time in 12-hour format to set
     */
    public void setArrivalTime12HourFormat(String arrivalTime12HourFormat) {
        this.arrivalTime12HourFormat = arrivalTime12HourFormat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Double.compare(flight.price, price) == 0 &&
               availableSeats == flight.availableSeats &&
               Objects.equals(id, flight.id) &&
               Objects.equals(flightNumber, flight.flightNumber) &&
               Objects.equals(origin, flight.origin) &&
               Objects.equals(destination, flight.destination) &&
               Objects.equals(departureTime, flight.departureTime) &&
               Objects.equals(arrivalTime, flight.arrivalTime) &&
               Objects.equals(departureTime12HourFormat, flight.departureTime12HourFormat) &&
               Objects.equals(arrivalTime12HourFormat, flight.arrivalTime12HourFormat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flightNumber, origin, destination, departureTime, arrivalTime, price, availableSeats, departureTime12HourFormat, arrivalTime12HourFormat);
    }
}