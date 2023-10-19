package com.example.christmasplanner.repository;

import com.example.christmasplanner.model.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface GiftRepository extends JpaRepository<Gift, Long> {

    Optional<Gift> findById(Long giftId);

    Gift findByName(String giftName);
}
