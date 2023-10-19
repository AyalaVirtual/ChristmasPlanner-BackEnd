package com.example.christmasplanner.service;

import com.example.christmasplanner.model.Gift;
import com.example.christmasplanner.repository.GiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class GiftService {

    private GiftRepository giftRepository;


    @Autowired
    public void setGiftRepository(GiftRepository giftRepository) {
        this.giftRepository = giftRepository;
    }


    public List<Gift> getAllGifts() {
        return giftRepository.findAll();
    }



}
