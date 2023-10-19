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

    @PostMapping(path="/decorations/")
    public ResponseEntity<?> createDecoration(@RequestBody Decoration decorationObject)  {

        Decoration newDecoration = decorationService.createDecoration(decorationObject);

        if (newDecoration != null) {
            message.put("message", "success");
            message.put("data", newDecoration);
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        } else {
            message.put("message", "unable to create a decoration at this time");
            return new ResponseEntity<>(message, HttpStatus.CONFLICT);
        }
    }

    @PutMapping(path="/decorations/{decorationId}/")
    public ResponseEntity<?> updateDecoration(@PathVariable(value="decorationId") Long decorationId, @RequestBody Decoration decorationObject) throws InformationNotFoundException {

        Optional<Decoration> decorationToUpdate = decorationService.updateDecoration(decorationId, decorationObject);

        if (decorationToUpdate.isPresent()) {
            message.put("message", "success");
            message.put("data", decorationToUpdate);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "decoration with id " + decorationId + " not found");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

}
