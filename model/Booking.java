package com.example.airtravelwebapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * Entity class representing a booking in the air travel web application.
 */
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier for the booking

    @ManyToOne
    private Flight flight; // The flight being booked

    private Long userId; // ID of the user who made the booking

    private String bookingDate; // Date of the booking

    // Getters and setters

    /**
     * Gets the unique identifier for the booking.
     * 
     * @return the booking ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the booking.
     * 
     * @param id the booking ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the ID of the user who made the booking.
     * 
     * @return the user ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets the ID of the user who made the booking.
     * 
     * @param userId the user ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Gets the flight being booked.
     * 
     * @return the flight
     */
    public Flight getFlight() {
        return flight;
    }

    /**
     * Sets the flight being booked.
     * 
     * @param flight the flight to set
     */
    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    /**
     * Gets the date of the booking.
     * 
     * @return the booking date
     */
    public String getBookingDate() {
        return bookingDate;
    }

    /**
     * Sets the date of the booking.
     * 
     * @param bookingDate the booking date to set
     */
    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }
}