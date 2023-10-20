package com.example.christmasplanner.repository;

import com.example.christmasplanner.model.Decoration;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


@Repository
public interface DecorationRepository extends JpaRepository<Decoration, Long> {
    // This method finds a decoration by its id
    Optional<Decoration> findById(Long decorationId);

    // This method finds a decoration by its name
    Decoration findByName(String decorationName);
}
