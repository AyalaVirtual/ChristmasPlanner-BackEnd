package com.example.christmasplanner.controller;

import com.example.christmasplanner.model.Decoration;
import com.example.christmasplanner.service.DecorationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


@RestController
@RequestMapping("/api")
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
            message.put("message", "cannot find any decorations");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        } else {
            message.put("message", "success");
            message.put("data", decorationList);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
    }




}
