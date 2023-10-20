package com.example.christmasplanner.repository;

import com.example.christmasplanner.model.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface GiftRepository extends JpaRepository<Gift, Long> {
    // This method finds a gift by its id
    Optional<Gift> findById(Long giftId);

    // This method finds a gift by its name
    Gift findByName(String giftName);
}
