package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Destination;

/**
 * Repository interface for {@link Destination} instances.
 * Provides abstract methods to perform CRUD operations on the "destinations"
 * table in the database.
 * This interface extends Spring Data JPA's JpaRepository, specifying the type
 * of entity and ID.
 */
public interface DestinationRepository extends JpaRepository<Destination, Long> {
}
