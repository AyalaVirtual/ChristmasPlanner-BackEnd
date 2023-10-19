package com.example.christmasplanner.service;

import com.example.christmasplanner.model.Decoration;
import com.example.christmasplanner.repository.DecorationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class DecorationService {

    private DecorationRepository decorationRepository;


    @Autowired
    public void setDecorationRepository(DecorationRepository decorationRepository) {
        this.decorationRepository = decorationRepository;
    }


    public List<Decoration> getAllDecorations() {
        return decorationRepository.findAll();
    }


}
