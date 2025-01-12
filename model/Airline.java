package com.example.airtravelwebapp.model;

/**
 * Represents the airline details of a flight.
 */
public class Airline {

    // Name of the airline
    private String name;

    // IATA code of the airline
    private String iata;

    // ICAO code of the airline
    private String icao;

    // Getter for the name of the airline
    public String getName() {
        return name;
    }

    // Setter for the name of the airline
    public void setName(String name) {
        this.name = name;
    }

    // Getter for the IATA code of the airline
    public String getIata() {
        return iata;
    }

    // Setter for the IATA code of the airline
    public void setIata(String iata) {
        this.iata = iata;
    }

    // Getter for the ICAO code of the airline
    public String getIcao() {
        return icao;
    }

    // Setter for the ICAO code of the airline
    public void setIcao(String icao) {
        this.icao = icao;
    }
}