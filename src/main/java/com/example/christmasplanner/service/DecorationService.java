package com.example.christmasplanner.service;

import com.example.christmasplanner.exception.InformationExistException;
import com.example.christmasplanner.exception.InformationNotFoundException;
import com.example.christmasplanner.model.Decoration;
import com.example.christmasplanner.repository.DecorationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


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

    public Optional<Decoration> getDecorationById(Long decorationId) {
        Optional<Decoration> decorationOptional = decorationRepository.findById(decorationId);

        if (decorationOptional.isPresent()) {
            return decorationOptional;
        } else {
            throw new InformationNotFoundException("decoration with id " + decorationId + " not found");
        }
    }

    public Decoration createDecoration(Decoration decorationObject) {
        Optional<Decoration> decorationOptional = Optional.ofNullable(decorationRepository.findByName(decorationObject.getName()));

        if (decorationOptional.isEmpty()) {
            return decorationRepository.save(decorationObject);
        } else {
            throw new InformationExistException("decoration with name " + decorationObject.getName() + " already exists");
        }
    }



}
