package com.example.christmasplanner.service;

import com.example.christmasplanner.exception.InformationExistException;
import com.example.christmasplanner.exception.InformationNotFoundException;
import com.example.christmasplanner.model.StockingStuffer;
import com.example.christmasplanner.repository.StockingStufferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockingStufferService {

    private StockingStufferRepository stockingStufferRepository;


    @Autowired
    public void setStockingStufferRepository(StockingStufferRepository stockingStufferRepository) {
        this.stockingStufferRepository = stockingStufferRepository;
    }


    public List<StockingStuffer> getAllStockingStuffers() {
        return stockingStufferRepository.findAll();
    }

    public Optional<StockingStuffer> getStockingStufferById(Long stockingStufferId) {
        Optional<StockingStuffer> stockingStufferOptional = stockingStufferRepository.findById(stockingStufferId);

        if (stockingStufferOptional.isPresent()) {
            return stockingStufferOptional;
        } else {
            throw new InformationNotFoundException("stocking stuffer with id " + stockingStufferId + " not found");
        }
    }

    public StockingStuffer createStockingStuffer(StockingStuffer stockingStufferObject) {
        Optional<StockingStuffer> stockingStufferOptional = Optional.ofNullable(stockingStufferRepository.findByName(stockingStufferObject.getName()));

        if (stockingStufferOptional.isEmpty()) {
            stockingStufferRepository.save(stockingStufferObject);
            return stockingStufferObject;
        } else {
            throw new InformationExistException("stocking stuffer with name " + stockingStufferObject.getName() + " already exists");
        }
    }

    public Optional<StockingStuffer> updateStockingStuffer(Long stockingStufferId, StockingStuffer stockingStufferObject) {
        Optional<StockingStuffer> stockingStufferOptional = stockingStufferRepository.findById(stockingStufferId);

        if (stockingStufferOptional.isPresent()) {
            stockingStufferOptional.get().setName(stockingStufferObject.getName());
            stockingStufferOptional.get().setDescription(stockingStufferObject.getDescription());
            stockingStufferRepository.save(stockingStufferOptional.get());
            return stockingStufferOptional;
        } else {
            throw new InformationNotFoundException("stocking stuffer with id " + stockingStufferId + " not found");
        }
    }

}
