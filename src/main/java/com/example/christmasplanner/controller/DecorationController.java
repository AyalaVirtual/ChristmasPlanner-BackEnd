package com.example.christmasplanner.controller;

import com.example.christmasplanner.model.Decoration;
import com.example.christmasplanner.service.DecorationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class DecorationController {

    private DecorationService decorationService;


    @Autowired
    public void setDecorationService(DecorationService decorationService) {
        this.decorationService = decorationService;
    }


    @GetMapping(path="/decorations/")
    public List<Decoration> getAllDecorations() {
        return decorationService.getAllDecorations();
    }
}
