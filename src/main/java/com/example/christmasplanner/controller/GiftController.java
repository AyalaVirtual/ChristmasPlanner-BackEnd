package com.example.christmasplanner.controller;

import com.example.christmasplanner.model.Gift;
import com.example.christmasplanner.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/api")
public class GiftController {

    private GiftService giftService;

    HashMap<String, Object> result = new HashMap<>();
    HashMap<String, Object> message = new HashMap<>();


    @Autowired
    public void setGiftService(GiftService giftService) {
        this.giftService = giftService;
    }


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



}
