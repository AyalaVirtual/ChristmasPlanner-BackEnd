package com.example.christmasplanner.controller;

import com.example.christmasplanner.exception.InformationNotFoundException;
import com.example.christmasplanner.model.Gift;
import com.example.christmasplanner.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/api/")
public class GiftController {

    private GiftService giftService;

    HashMap<String, Object> result = new HashMap<>();
    HashMap<String, Object> message = new HashMap<>();


    @Autowired
    public void setGiftService(GiftService giftService) {
        this.giftService = giftService;
    }


    /**
     * This sets the path for GET requests for all gifts and checks if the list of gifts is empty or not before deciding whether to send an HTTP status message of OK or NOT FOUND
     *
     * @return the HTTP status message
     */
    @GetMapping(path="/gifts/")
    public ResponseEntity<?> getAllGifts() {

        List<Gift> giftList = giftService.getAllGifts();

        if (giftList.isEmpty()) {
            message.put("message", "gift list not found");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        } else {
            message.put("message", "success");
            message.put("data", giftList);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
    }

    @GetMapping(path="/gifts/{giftId}/")
    public ResponseEntity<?> getGiftById(@PathVariable(value="giftId") Long giftId) {

        Optional<Gift> giftOptional = giftService.getGiftById(giftId);

        if (giftOptional.isPresent()) {
            message.put("message", "success");
            message.put("data", giftOptional);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "gift with id " + giftId + " not found");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path="/gifts/")
    public ResponseEntity<?> createGift(@RequestBody Gift giftObject) {

        Gift newGift = giftService.createGift(giftObject);

        if (newGift != null) {
            message.put("message", "success");
            message.put("data", newGift);
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        } else {
            message.put("message", "gift with name " + giftObject.getName() + " already exists");
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
    }

    @PutMapping(path="/gifts/{giftId}/")
    public ResponseEntity<?> updateGift(@PathVariable(value="giftId") Long giftId, @RequestBody Gift giftObject) throws InformationNotFoundException {

        Optional<Gift> giftToUpdate = giftService.updateGift(giftId, giftObject);

        if (giftToUpdate.isPresent()) {
            message.put("message", "success");
            message.put("data", giftToUpdate);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "gift with id " + giftId + " not found");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/gifts/{giftId}/")
    public ResponseEntity<?> deleteGift(@PathVariable(value="giftId") Long giftId) {
        Optional<Gift> giftToDelete = giftService.deleteGift(giftId);

        if (giftToDelete.isPresent()) {
            message.put("message", "success");
            message.put("data", giftToDelete);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "gift with id " + giftId + " not found");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

}
