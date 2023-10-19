package com.example.christmasplanner.service;

import com.example.christmasplanner.exception.InformationExistException;
import com.example.christmasplanner.exception.InformationNotFoundException;
import com.example.christmasplanner.model.Gift;
import com.example.christmasplanner.repository.GiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


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

    public Optional<Gift> getGiftById(Long giftId) {
        Optional<Gift> giftOptional = giftRepository.findById(giftId);

        if (giftOptional.isPresent()) {
            return giftOptional;
        } else {
            throw new InformationNotFoundException("gift with id " + giftId + " not found");
        }
    }

    public Gift createGift(Gift giftObject) {
        Gift gift = giftRepository.findByName(giftObject.getName());

        if (gift != null) {
            throw new InformationExistException("gift with name " + giftObject.getName() + " already exists");
        } else {
            giftRepository.save(giftObject);
            return giftObject;
        }
    }

    public Optional<Gift> updateGift(Long giftId, Gift giftObject) {
        Optional<Gift> giftOptional = giftRepository.findById(giftId);

        if (giftOptional.isPresent()) {
            giftOptional.get().setName(giftObject.getName());
            giftOptional.get().setDescription(giftObject.getDescription());
            giftRepository.save(giftOptional.get());
            return giftOptional;
        } else {
            throw new InformationNotFoundException("gift with id " + giftId + " not found");
        }
    }

}
