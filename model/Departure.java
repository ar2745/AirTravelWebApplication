package com.example.airtravelwebapp.model;

/**
 * Represents the departure details of a flight.
 */
public class Departure {
    private String airport; // The name of the departure airport
    private String timezone; // The timezone of the departure airport
    private String iata; // The IATA code of the departure airport
    private String icao; // The ICAO code of the departure airport
    private String terminal; // The terminal at the departure airport
    private String gate; // The gate at the departure airport
    private Integer delay; // The delay in minutes for the departure
    private String scheduled; // The scheduled departure time
    private String estimated; // The estimated departure time
    private String actual; // The actual departure time
    private String estimated_runway; // The estimated runway departure time
    private String actual_runway; // The actual runway departure time

    // Getters and setters

    /**
     * Gets the name of the departure airport.
     * @return the name of the departure airport
     */
    public String getAirport() {
        return airport;
    }

    /**
     * Sets the name of the departure airport.
     * @param airport the name of the departure airport
     */
    public void setAirport(String airport) {
        this.airport = airport;
    }

    /**
     * Gets the timezone of the departure airport.
     * @return the timezone of the departure airport
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     * Sets the timezone of the departure airport.
     * @param timezone the timezone of the departure airport
     */
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    /**
     * Gets the IATA code of the departure airport.
     * @return the IATA code of the departure airport
     */
    public String getIata() {
        return iata;
    }

    /**
     * Sets the IATA code of the departure airport.
     * @param iata the IATA code of the departure airport
     */
    public void setIata(String iata) {
        this.iata = iata;
    }

    /**
     * Gets the ICAO code of the departure airport.
     * @return the ICAO code of the departure airport
     */
    public String getIcao() {
        return icao;
    }

    /**
     * Sets the ICAO code of the departure airport.
     * @param icao the ICAO code of the departure airport
     */
    public void setIcao(String icao) {
        this.icao = icao;
    }

    /**
     * Gets the terminal at the departure airport.
     * @return the terminal at the departure airport
     */
    public String getTerminal() {
        return terminal;
    }

    /**
     * Sets the terminal at the departure airport.
     * @param terminal the terminal at the departure airport
     */
    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    /**
     * Gets the gate at the departure airport.
     * @return the gate at the departure airport
     */
    public String getGate() {
        return gate;
    }

    /**
     * Sets the gate at the departure airport.
     * @param gate the gate at the departure airport
     */
    public void setGate(String gate) {
        this.gate = gate;
    }

    /**
     * Gets the delay in minutes for the departure.
     * @return the delay in minutes for the departure
     */
    public Integer getDelay() {
        return delay;
    }

    /**
     * Sets the delay in minutes for the departure.
     * @param delay the delay in minutes for the departure
     */
    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    /**
     * Gets the scheduled departure time.
     * @return the scheduled departure time
     */
    public String getScheduled() {
        return scheduled;
    }

    /**
     * Sets the scheduled departure time.
     * @param scheduled the scheduled departure time
     */
    public void setScheduled(String scheduled) {
        this.scheduled = scheduled;
    }

    /**
     * Gets the estimated departure time.
     * @return the estimated departure time
     */
    public String getEstimated() {
        return estimated;
    }

    /**
     * Sets the estimated departure time.
     * @param estimated the estimated departure time
     */
    public void setEstimated(String estimated) {
        this.estimated = estimated;
    }

    /**
     * Gets the actual departure time.
     * @return the actual departure time
     */
    public String getActual() {
        return actual;
    }

    /**
     * Sets the actual departure time.
     * @param actual the actual departure time
     */
    public void setActual(String actual) {
        this.actual = actual;
    }

    /**
     * Gets the estimated runway departure time.
     * @return the estimated runway departure time
     */
    public String getEstimated_runway() {
        return estimated_runway;
    }

    /**
     * Sets the estimated runway departure time.
     * @param estimated_runway the estimated runway departure time
     */
    public void setEstimated_runway(String estimated_runway) {
        this.estimated_runway = estimated_runway;
    }

    /**
     * Gets the actual runway departure time.
     * @return the actual runway departure time
     */
    public String getActual_runway() {
        return actual_runway;
    }

    /**
     * Sets the actual runway departure time.
     * @param actual_runway the actual runway departure time
     */
    public void setActual_runway(String actual_runway) {
        this.actual_runway = actual_runway;
    }
}