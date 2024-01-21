package com.example.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Destination;
import com.example.service.DestinationService;

/**
 * Controller for handling requests related to Destinations.
 * This controller handles all CRUD operations for Destination objects.
 */
@RestController
public class DestinationController {

    private final DestinationService destinationService;

    /**
     * Constructs a new DestinationController with the given DestinationService.
     *
     * @param destinationService the service to be used for handling destination
     *                           data
     */
    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    /**
     * Returns a welcome message.
     *
     * @return a string containing a welcome message
     */
    @GetMapping("/")
    public String home() {
        return "Welcome! You are all set to go!";
    }

    /**
     * Returns a promotional message.
     *
     * @return a string containing a promotional message
     */
    @GetMapping("/messages")
    public String getMessages() {
        return "Black Friday! Get 50% cashback on saving your first spot.";
    }

    /**
     * Returns a list of destinations, optionally filtered by country and limited by
     * count.
     *
     * @param count   the maximum number of destinations to return, defaults to 10
     *                if not provided
     * @param country an optional parameter to filter destinations by country
     * @return a list of destinations, filtered by country if provided, and limited
     *         to the specified count
     */
    @GetMapping("/destinations")
    public List<Destination> getDestinations(@RequestParam(required = false, defaultValue = "20") int count,
            @RequestParam(required = false) String country) {
        return destinationService.getAllDestinations().stream()
                .filter(d -> country == null || d.getCountry().equalsIgnoreCase(country))
                .limit(count)
                .collect(Collectors.toList());
    }

    /**
     * Returns the destination with the given ID, or a 404 Not Found status if the
     * ID does not exist.
     *
     * @param id the ID of the destination to return
     * @return a ResponseEntity containing the destination if found, or a 404 Not
     *         Found status with an error message
     */
    @GetMapping("/destinations/{id}")
    public ResponseEntity<?> getDestinationById(@PathVariable Long id) {
        Optional<Destination> destination = destinationService.getDestinationById(id);

        return destination.<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Destination not found"));
    }

    /**
     * Adds a new destination and returns the added destination, or a 400 Bad
     * Request status if the destination could not be added.
     *
     * @param destination the destination to add
     * @return a ResponseEntity containing the added destination if successful, or a
     *         400 Bad Request status with an error message
     */
    @PostMapping("/destinations")
    public ResponseEntity<?> addDestination(@RequestBody Destination destination) {
        Optional<Destination> addedDestination = destinationService.addDestination(destination);

        return addedDestination.<ResponseEntity<?>>map(d -> ResponseEntity.status(HttpStatus.CREATED).body(d))
                .orElseGet(() -> ResponseEntity.badRequest().body("Failed to add destination"));
    }

    /**
     * Updates the destination with the given ID and returns the updated
     * destination,
     * or a 400 Bad Request status if the destination could not be updated.
     *
     * @param id          the ID of the destination to update
     * @param destination the destination data to update with
     * @return a ResponseEntity containing the updated destination if successful,
     *         or a 400 Bad Request status with an error message
     */
    @PutMapping("/destinations/{id}")
    public ResponseEntity<?> updateDestination(@PathVariable Long id, @RequestBody Destination destination) {
        Optional<Destination> updatedDestination = destinationService.updateDestination(id, destination);

        return updatedDestination.<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().body("Destination not found"));
    }

    /**
     * Deletes the destination with the given ID and returns a success message,
     * or a 404 Not Found status if the ID does not exist.
     *
     * @param id the ID of the destination to delete
     * @return a ResponseEntity with a success message if the deletion was
     *         successful,
     *         or a 404 Not Found status with an error message
     */
    @DeleteMapping("/destinations/{id}")
    public ResponseEntity<?> deleteDestionation(@PathVariable Long id) {
        boolean deleted = destinationService.deleteDestination(id);

        return deleted ? ResponseEntity.ok("Destination deleted successfully")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Destination not found");
    }

}
