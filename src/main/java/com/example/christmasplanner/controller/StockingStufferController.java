package com.example.christmasplanner.controller;

import com.example.christmasplanner.model.StockingStuffer;
import com.example.christmasplanner.service.StockingStufferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/api")
public class StockingStufferController {

    private StockingStufferService stockingStufferService;

    HashMap<String, Object> result = new HashMap<>();
    HashMap<String, Object> message = new HashMap<>();


    @Autowired
    public void setStockingStufferService(StockingStufferService stockingStufferService) {
        this.stockingStufferService = stockingStufferService;
    }


    @GetMapping(path="/stockingstuffers/")
    public ResponseEntity<?> getAllStockingStuffers() {
        List<StockingStuffer> stockingStufferList = stockingStufferService.getAllStockingStuffers();

        if (stockingStufferList.isEmpty()) {
            message.put("message", "stocking stuffer list not found");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        } else {
            message.put("message", "success");
            message.put("data", stockingStufferList);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
    }



}
