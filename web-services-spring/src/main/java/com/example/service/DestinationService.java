package com.example.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.model.Destination;
import com.example.repository.DestinationRepository;

/**
 * Service class for managing destinations.
 * This class provides methods to perform CRUD operations on destinations using
 * the {@link DestinationRepository}.
 */
@Service
public class DestinationService {
    private final DestinationRepository destinationRepository;
    private final Logger logger = LoggerFactory.getLogger(DestinationService.class);

    /**
     * Constructs a new DestinationService with the given DestinationRepository.
     *
     * @param destinationRepository the repository to use for managing destinations
     */
    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    /**
     * Returns all destinations in the database.
     *
     * @return a list of all destinations
     */
    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

    /**
     * Returns the destination with the given ID, or an empty Optional if the ID
     * does not exist.
     *
     * @param id the ID of the destination to return
     * @return an Optional containing the destination if found, or an empty Optional
     */
    public Optional<Destination> getDestinationById(Long id) {
        return destinationRepository.findById(id);
    }

    /**
     * Adds a new destination to the database.
     * If the destination is not valid, or if a DataIntegrityViolationException is
     * thrown, an empty Optional is returned.
     *
     * @param destination the destination to add
     * @return an Optional containing the added destination if successful, or an
     *         empty Optional
     */
    public Optional<Destination> addDestination(Destination destination) {
        if (!isDestinationValid(destination)) {
            return Optional.empty();
        }

        try {
            return Optional.of(destinationRepository.save(destination));
        } catch (DataIntegrityViolationException e) {
            logger.error("Error occurred while adding destination", e);
            return Optional.empty();
        }
    }

    /**
     * Updates the destination with the given ID in the database.
     * If the destination is not valid, or if a DataIntegrityViolationException is
     * thrown, or if the ID does not exist, an empty Optional is returned.
     *
     * @param id          the ID of the destination to update
     * @param destination the destination to update
     * @return an Optional containing the updated destination if successful, or an
     *         empty Optional
     */
    public Optional<Destination> updateDestination(Long id, Destination destination) {
        if (!isDestinationValid(destination)) {
            return Optional.empty();
        }

        Optional<Destination> destinationOptional = destinationRepository.findById(id);
        if (destinationOptional.isPresent()) {
            Destination destinationToUpdate = destinationOptional.get();
            destinationToUpdate.setCity(destination.getCity());
            destinationToUpdate.setCountry(destination.getCountry());
            destinationToUpdate.setDescription(destination.getDescription());

            try {
                return Optional.of(destinationRepository.save(destinationToUpdate));
            } catch (DataIntegrityViolationException e) {
                logger.error("Error occurred while updating destination", e);
                return Optional.empty();
            }
        } else {
            return Optional.empty();
        }
    }

    /**
     * Deletes the destination with the given ID from the database.
     * If the ID does not exist, this method returns false.
     *
     * @param id the ID of the destination to delete
     * @return true if the destination was deleted, false otherwise
     */
    public boolean deleteDestination(Long id) {
        Optional<Destination> destinationOptional = destinationRepository.findById(id);
        if (destinationOptional.isPresent()) {
            destinationRepository.delete(destinationOptional.get());
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns true if the given destination is valid, false otherwise.
     * A destination is valid if it is not null, and if all of its fields are not
     * null or empty.
     *
     * @param destination the destination to validate
     * @return true if the given destination is valid, false otherwise
     */
    private boolean isDestinationValid(Destination destination) {
        return destination != null && destination.getCity() != null && destination.getCity().trim().length() > 0
                && destination.getCountry() != null && destination.getCountry().trim().length() > 0
                && destination.getDescription() != null && destination.getDescription().trim().length() > 0;
    }
}
