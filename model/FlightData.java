package com.example.airtravelwebapp.model;

/**
 * Represents the data of a flight.
 */
public class FlightData {
    private String flight_date; // The date of the flight
    private String flight_status; // The status of the flight
    private Departure departure; // The departure details of the flight
    private Arrival arrival; // The arrival details of the flight
    private Airline airline; // The airline operating the flight
    private Flight flight; // The flight details

    // Getters and setters

    /**
     * Gets the date of the flight.
     * @return the date of the flight
     */
    public String getFlight_date() {
        return flight_date;
    }

    /**
     * Sets the date of the flight.
     * @param flight_date the date of the flight
     */
    public void setFlight_date(String flight_date) {
        this.flight_date = flight_date;
    }

    /**
     * Gets the status of the flight.
     * @return the status of the flight
     */
    public String getFlight_status() {
        return flight_status;
    }

    /**
     * Sets the status of the flight.
     * @param flight_status the status of the flight
     */
    public void setFlight_status(String flight_status) {
        this.flight_status = flight_status;
    }

    /**
     * Gets the departure details of the flight.
     * @return the departure details of the flight
     */
    public Departure getDeparture() {
        return departure;
    }

    /**
     * Sets the departure details of the flight.
     * @param departure the departure details of the flight
     */
    public void setDeparture(Departure departure) {
        this.departure = departure;
    }

    /**
     * Gets the arrival details of the flight.
     * @return the arrival details of the flight
     */
    public Arrival getArrival() {
        return arrival;
    }

    /**
     * Sets the arrival details of the flight.
     * @param arrival the arrival details of the flight
     */
    public void setArrival(Arrival arrival) {
        this.arrival = arrival;
    }

    /**
     * Gets the airline operating the flight.
     * @return the airline operating the flight
     */
    public Airline getAirline() {
        return airline;
    }

    /**
     * Sets the airline operating the flight.
     * @param airline the airline operating the flight
     */
    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    /**
     * Gets the flight details.
     * @return the flight details
     */
    public Flight getFlight() {
        return flight;
    }

    /**
     * Sets the flight details.
     * @param flight the flight details
     */
    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}