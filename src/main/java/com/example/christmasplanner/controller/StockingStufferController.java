package com.example.christmasplanner.controller;

import com.example.christmasplanner.exception.InformationNotFoundException;
import com.example.christmasplanner.model.StockingStuffer;
import com.example.christmasplanner.service.StockingStufferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/")
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

    @GetMapping(path="/stockingstuffers/{stockingStufferId}/")
    public ResponseEntity<?> getStockingStufferById(@PathVariable(value="stockingStufferId") Long stockingStufferId) {

        Optional<StockingStuffer> stockingStufferOptional = stockingStufferService.getStockingStufferById(stockingStufferId);

        if (stockingStufferOptional.isPresent()) {
            message.put("message", "success");
            message.put("data", stockingStufferOptional);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "stocking stuffer with id " + stockingStufferId + " not found");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path="/stockingstuffers/")
    public ResponseEntity<?> createStockingStuffer(@PathVariable(value="stockingStufferId") Long stockingStufferId, @RequestBody StockingStuffer stockingStufferObject) {

        StockingStuffer newStockingStuffer = stockingStufferService.createStockingStuffer(stockingStufferObject);

        if (newStockingStuffer != null) {
            message.put("message", "success");
            message.put("data", newStockingStuffer);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "stocking stuffer with name " + stockingStufferObject.getName() + " already exists");
            return new ResponseEntity<>(message, HttpStatus.CONFLICT);
        }
    }

    @PutMapping(path="/stockingstuffers/{stockingStufferId}/")
    public ResponseEntity<?> updateStockingStuffer(@PathVariable(value="stockingStufferId") Long stockingStufferId, @RequestBody StockingStuffer stockingStufferObject) throws InformationNotFoundException {

        Optional<StockingStuffer> stockingStufferToUpdate = stockingStufferService.updateStockingStuffer(stockingStufferId, stockingStufferObject);

        if (stockingStufferToUpdate.isPresent()) {
            message.put("message", "success");
            message.put("data", stockingStufferToUpdate);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "stocking stuffer with id " + stockingStufferId + " not found");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

}
