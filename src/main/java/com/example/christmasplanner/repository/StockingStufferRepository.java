package com.example.christmasplanner.repository;

import com.example.christmasplanner.model.StockingStuffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface StockingStufferRepository extends JpaRepository<StockingStuffer, Long> {
    // This method finds a stocking stuffer by its id
    Optional<StockingStuffer> findById(Long stockingStufferId);

    // This method finds a stocking stuffer by its name
    StockingStuffer findByName(String stockingStufferName);
}
