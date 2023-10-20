package com.example.christmasplanner.controller;

import com.example.christmasplanner.exception.InformationExistException;
import com.example.christmasplanner.exception.InformationNotFoundException;
import com.example.christmasplanner.model.Decoration;
import com.example.christmasplanner.service.DecorationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/")
public class DecorationController {

    private DecorationService decorationService;

    static HashMap<String, Object> result = new HashMap<>();
    static HashMap<String, Object> message = new HashMap<>();


    @Autowired
    public void setDecorationService(DecorationService decorationService) {
        this.decorationService = decorationService;
    }


    /**
     * This sets the path for GET requests for all decorations and checks if the list of decorations is empty or not before deciding whether to send an HTTP status message of OK or NOT FOUND
     *
     * @return the HTTP status message
     */
    @GetMapping(path="/decorations/")
    public ResponseEntity<?> getAllDecorations() {

        List<Decoration> decorationList = decorationService.getAllDecorations();

        if (decorationList.isEmpty()) {
            message.put("message", "decoration list not found");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        } else {
            message.put("message", "success");
            message.put("data", decorationList);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
    }


    /**
     * This sets the path for GET requests for an individual decoration and checks if the decoration exists or not before deciding whether to send an HTTP status message of OK or NOT FOUND
     *
     * @param decorationId represents the id of the specific decoration the user is trying to get
     * @return the HTTP status message
     */
    @GetMapping(path="/decorations/{decorationId}/")
    public ResponseEntity<?> getDecorationById(@PathVariable(value="decorationId") Long decorationId) {

        Optional<Decoration> decorationOptional = decorationService.getDecorationById(decorationId);

        if (decorationOptional.isPresent()) {
            message.put("message", "success");
            message.put("data", decorationOptional);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "decoration with id" + decorationId + " not found");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }


    /**
     * This sets the path for POST requests for a new decoration and checks if the decoration exists or not before deciding whether to send an HTTP status message of CREATED or CONFLICT
     *
     * @param decorationObject represents the new decoration the user is trying to create
     * @return the HTTP status message
     */
    @PostMapping(path="/decorations/")
    public ResponseEntity<?> createDecoration(@RequestBody Decoration decorationObject)  {

        Decoration newDecoration = decorationService.createDecoration(decorationObject);

        if (newDecoration != null) {
            message.put("message", "success");
            message.put("data", newDecoration);
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        } else {
            message.put("message", "decoration with name " + newDecoration.getName() + " already exists");
            return new ResponseEntity<>(message, HttpStatus.CONFLICT);
        }
    }


    /**
     * This sets the path for PUT requests for an existing decoration and checks if the decoration exists or not before deciding whether to send an HTTP status message of OK or NOT FOUND
     *
     * @param decorationId represents the id of the decoration the user is trying to update
     * @param decorationObject represents the updated version of the decoration
     * @return the HTTP status message
     */
    @PutMapping(path="/decorations/{decorationId}/")
    public ResponseEntity<?> updateDecoration(@PathVariable(value="decorationId") Long decorationId, @RequestBody Decoration decorationObject) throws InformationNotFoundException {

        Optional<Decoration> decorationToUpdate = decorationService.updateDecoration(decorationId, decorationObject);

        if (decorationToUpdate.isPresent()) {
            message.put("message", "success");
            message.put("data", decorationToUpdate.get());
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "decoration with id " + decorationId + " not found");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }


    /**
     * This sets the path for DELETE requests for an existing decoration and checks if the decoration exists or not before deciding whether to send an HTTP status message of OK or NOT FOUND
     *
     * @param decorationId represents the id of the decoration the user is trying to delete
     * @return the HTTP status message
     */
    @DeleteMapping(path="/decorations/{decorationId}/")
    public ResponseEntity<?> deleteDecoration(@PathVariable(value="decorationId") Long decorationId) {

        Optional<Decoration> decorationToDelete = decorationService.deleteDecoration(decorationId);

        if (decorationToDelete.isPresent()) {
            message.put("message", "success");
            message.put("data", decorationToDelete);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "decoration with id " + decorationId + " not found");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

}
