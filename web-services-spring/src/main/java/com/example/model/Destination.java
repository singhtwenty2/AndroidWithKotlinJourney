package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a travel destination.
 * This class is a JPA entity class that maps to the "destinations" table in the
 * database.
 */
@Entity
@Table(name = "destinations")
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String description;
    private String country;

    /**
     * Default constructor required by JPA.
     */
    public Destination() {
    }

    /**
     * Constructs a new Destination with the given city, description, and country.
     *
     * @param city        the city of the destination
     * @param description the description of the destination
     * @param country     the country of the destination
     */
    public Destination(String city, String description, String country) {
        this.city = city;
        this.description = description;
        this.country = country;
    }

    /**
     * Returns the ID of this destination.
     *
     * @return the ID of this destination
     */
    public Long getId() {
        return id;
    }

    /**
     * Returns the city of this destination.
     *
     * @return the city of this destination
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city of this destination.
     * If the provided city is null or empty, an IllegalArgumentException is thrown.
     *
     * @param city the city to set
     * @throws IllegalArgumentException if the provided city is null or empty
     */
    public void setCity(String city) {
        if (city == null || city.trim().length() == 0) {
            throw new IllegalArgumentException("City cannot be empty");
        }
        this.city = city;
    }

    /**
     * Returns the description of this destination.
     *
     * @return the description of this destination
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of this destination.
     * If the provided description is null or empty, an IllegalArgumentException is
     * thrown.
     *
     * @param description the description to set
     * @throws IllegalArgumentException if the provided description is null or empty
     */
    public void setDescription(String description) {
        if (description == null || description.trim().length() == 0) {
            throw new IllegalArgumentException("Description cannot be empty");
        }
        this.description = description;
    }

    /**
     * Returns the country of this destination.
     *
     * @return the country of this destination
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country of this destination.
     * If the provided country is null or empty, an IllegalArgumentException is
     * thrown.
     *
     * @param country the country to set
     * @throws IllegalArgumentException if the provided country is null or empty
     */
    public void setCountry(String country) {
        if (country == null || country.trim().length() == 0) {
            throw new IllegalArgumentException("Country cannot be empty");
        }
        this.country = country;
    }
}
