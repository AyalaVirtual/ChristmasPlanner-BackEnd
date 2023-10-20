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


    /**
     * This is a GET request that checks to see if the list of gifts is empty before either throwing an InformationNotFoundException, or  returning the list of gifts
     *
     * @return a list of all gifts
     */
    public List<Gift> getAllGifts() {
        return giftRepository.findAll();
    }


    /**
     * This is a GET request that checks to see if an individual gift exists before either returning it, or throwing an InformationNotFoundException
     *
     * @param giftId represents the id of the specific gift the user is trying to get
     * @return gift by id if it exists
     */
    public Optional<Gift> getGiftById(Long giftId) {
        Optional<Gift> giftOptional = giftRepository.findById(giftId);

        if (giftOptional.isPresent()) {
            return giftOptional;
        } else {
            throw new InformationNotFoundException("gift with id " + giftId + " not found");
        }
    }


    /**
     * This is a POST request that checks to see if a gift already exists before either throwing an InformationExistException, or saving the newly created gift to the repository
     *
     * @param giftObject represents the new gift the user is trying to create
     * @return newly created gift
     */
    public Gift createGift(Gift giftObject) {
        Gift gift = giftRepository.findByName(giftObject.getName());

        if (gift != null) {
            throw new InformationExistException("gift with name " + giftObject.getName() + " already exists");
        } else {
            giftRepository.save(giftObject);
            return giftObject;
        }
    }


    /**
     * This is a PUT request that checks to see if a gift exists before either throwing an InformationNotFoundException, or setting the attributes and saving the newly updated gift to the repository
     *
     * @param giftId represents the id of the gift the user is trying to update
     * @param giftObject represents the updated version of the gift
     * @return the newly updated gift
     */
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



    public Optional<Gift> deleteGift(Long giftId) {
        Optional<Gift> giftOptional = giftRepository.findById(giftId);

        if (giftOptional.isPresent()) {
            giftRepository.deleteById(giftId);
            return giftOptional;
        } else {
            throw new InformationNotFoundException("gift with id " + giftId + " not found");
        }
    }

}
