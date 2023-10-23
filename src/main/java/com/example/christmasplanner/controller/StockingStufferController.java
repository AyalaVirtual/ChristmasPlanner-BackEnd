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
@RequestMapping("/api")
public class StockingStufferController {

    private StockingStufferService stockingStufferService;

    HashMap<String, Object> result = new HashMap<>();
    HashMap<String, Object> message = new HashMap<>();


    @Autowired
    public void setStockingStufferService(StockingStufferService stockingStufferService) {
        this.stockingStufferService = stockingStufferService;
    }


    /**
     * This sets the path for GET requests for all stocking stuffers and checks if the list of stuffers is empty or not before deciding whether to send an HTTP status message of OK or NOT FOUND
     *
     * @return the HTTP status message
     */
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


    /**
     * This sets the path for GET requests for an individual stocking stuffer and checks if the stocking stuffer exists or not before deciding whether to send an HTTP status message of OK or NOT FOUND
     *
     * @param stockingStufferId represents the id of the specific stocking stuffer the user is trying to get
     * @return the HTTP status message
     */
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


    /**
     * This sets the path for POST requests for a new stocking stuffer and checks if the stocking stuffer exists or not before deciding whether to send an HTTP status message of CREATED or CONFLICT
     *
     * @param stockingStufferObject represents the new stocking stuffer the user is trying to create
     * @return the HTTP status message
     */
    @PostMapping(path="/stockingstuffers/")
    public ResponseEntity<?> createStockingStuffer(@RequestBody StockingStuffer stockingStufferObject) {

        StockingStuffer newStockingStuffer = stockingStufferService.createStockingStuffer(stockingStufferObject);

        if (newStockingStuffer != null) {
            message.put("message", "success");
            message.put("data", newStockingStuffer);
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        } else {
            message.put("message", "stocking stuffer with name " + stockingStufferObject.getName() + " already exists");
            return new ResponseEntity<>(message, HttpStatus.CONFLICT);
        }
    }


    /**
     * This sets the path for PUT requests for an existing stocking stuffer and checks if the stocking stuffer exists or not before deciding whether to send an HTTP status message of OK or NOT FOUND
     *
     * @param stockingStufferId represents the id of the stocking stuffer the user is trying to update
     * @param stockingStufferObject represents the updated version of the stocking stuffer
     * @return the HTTP status message
     */
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


    /**
     * This sets the path for DELETE requests for an existing stocking stuffer and checks if the stocking stuffer exists or not before deciding whether to send an HTTP status message of OK or NOT FOUND
     *
     * @param stockingStufferId represents the id of the stocking stuffer the user is trying to delete
     * @return the HTTP status message
     */
    @DeleteMapping(path="/stockingstuffers/{stockingStufferId}/")
    public ResponseEntity<?> deleteStockingStuffer(@PathVariable(value="stockingStufferId") Long stockingStufferId) {

        Optional<StockingStuffer> stockingStufferToDelete = stockingStufferService.deleteStockingStuffer(stockingStufferId);

        if (stockingStufferToDelete.isPresent()) {
            message.put("message", "success");
            message.put("data", stockingStufferToDelete);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "stocking stuffer with id " + stockingStufferId + " not found");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

}
