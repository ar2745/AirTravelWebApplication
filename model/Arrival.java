package com.example.airtravelwebapp.model;

/**
 * Represents the arrival details of a flight.
 */
public class Arrival {
    private String airport; // The name of the arrival airport
    private String timezone; // The timezone of the arrival airport
    private String iata; // The IATA code of the arrival airport
    private String icao; // The ICAO code of the arrival airport
    private String terminal; // The terminal at the arrival airport
    private String gate; // The gate at the arrival airport
    private String baggage; // The baggage claim area at the arrival airport
    private Integer delay; // The delay in minutes for the arrival
    private String scheduled; // The scheduled arrival time
    private String estimated; // The estimated arrival time
    private String actual; // The actual arrival time
    private String estimated_runway; // The estimated runway arrival time
    private String actual_runway; // The actual runway arrival time

    // Getters and setters

    /**
     * Gets the name of the arrival airport.
     * @return the name of the arrival airport
     */
    public String getAirport() {
        return airport;
    }

    /**
     * Sets the name of the arrival airport.
     * @param airport the name of the arrival airport
     */
    public void setAirport(String airport) {
        this.airport = airport;
    }

    /**
     * Gets the timezone of the arrival airport.
     * @return the timezone of the arrival airport
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     * Sets the timezone of the arrival airport.
     * @param timezone the timezone of the arrival airport
     */
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    /**
     * Gets the IATA code of the arrival airport.
     * @return the IATA code of the arrival airport
     */
    public String getIata() {
        return iata;
    }

    /**
     * Sets the IATA code of the arrival airport.
     * @param iata the IATA code of the arrival airport
     */
    public void setIata(String iata) {
        this.iata = iata;
    }

    /**
     * Gets the ICAO code of the arrival airport.
     * @return the ICAO code of the arrival airport
     */
    public String getIcao() {
        return icao;
    }

    /**
     * Sets the ICAO code of the arrival airport.
     * @param icao the ICAO code of the arrival airport
     */
    public void setIcao(String icao) {
        this.icao = icao;
    }

    /**
     * Gets the terminal at the arrival airport.
     * @return the terminal at the arrival airport
     */
    public String getTerminal() {
        return terminal;
    }

    /**
     * Sets the terminal at the arrival airport.
     * @param terminal the terminal at the arrival airport
     */
    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    /**
     * Gets the gate at the arrival airport.
     * @return the gate at the arrival airport
     */
    public String getGate() {
        return gate;
    }

    /**
     * Sets the gate at the arrival airport.
     * @param gate the gate at the arrival airport
     */
    public void setGate(String gate) {
        this.gate = gate;
    }

    /**
     * Gets the baggage claim area at the arrival airport.
     * @return the baggage claim area at the arrival airport
     */
    public String getBaggage() {
        return baggage;
    }

    /**
     * Sets the baggage claim area at the arrival airport.
     * @param baggage the baggage claim area at the arrival airport
     */
    public void setBaggage(String baggage) {
        this.baggage = baggage;
    }

    /**
     * Gets the delay in minutes for the arrival.
     * @return the delay in minutes for the arrival
     */
    public Integer getDelay() {
        return delay;
    }

    /**
     * Sets the delay in minutes for the arrival.
     * @param delay the delay in minutes for the arrival
     */
    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    /**
     * Gets the scheduled arrival time.
     * @return the scheduled arrival time
     */
    public String getScheduled() {
        return scheduled;
    }

    /**
     * Sets the scheduled arrival time.
     * @param scheduled the scheduled arrival time
     */
    public void setScheduled(String scheduled) {
        this.scheduled = scheduled;
    }

    /**
     * Gets the estimated arrival time.
     * @return the estimated arrival time
     */
    public String getEstimated() {
        return estimated;
    }

    /**
     * Sets the estimated arrival time.
     * @param estimated the estimated arrival time
     */
    public void setEstimated(String estimated) {
        this.estimated = estimated;
    }

    /**
     * Gets the actual arrival time.
     * @return the actual arrival time
     */
    public String getActual() {
        return actual;
    }

    /**
     * Sets the actual arrival time.
     * @param actual the actual arrival time
     */
    public void setActual(String actual) {
        this.actual = actual;
    }

    /**
     * Gets the estimated runway arrival time.
     * @return the estimated runway arrival time
     */
    public String getEstimated_runway() {
        return estimated_runway;
    }

    /**
     * Sets the estimated runway arrival time.
     * @param estimated_runway the estimated runway arrival time
     */
    public void setEstimated_runway(String estimated_runway) {
        this.estimated_runway = estimated_runway;
    }

    /**
     * Gets the actual runway arrival time.
     * @return the actual runway arrival time
     */
    public String getActual_runway() {
        return actual_runway;
    }

    /**
     * Sets the actual runway arrival time.
     * @param actual_runway the actual runway arrival time
     */
    public void setActual_runway(String actual_runway) {
        this.actual_runway = actual_runway;
    }
}