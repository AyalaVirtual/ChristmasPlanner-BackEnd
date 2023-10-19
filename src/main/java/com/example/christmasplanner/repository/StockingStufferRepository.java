package com.example.christmasplanner.repository;

import com.example.christmasplanner.model.StockingStuffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface StockingStufferRepository extends JpaRepository<StockingStuffer, Long> {

    Optional<StockingStuffer> findById(Long stockingStufferId);

    StockingStuffer findByName(String stockingStufferName);
}
