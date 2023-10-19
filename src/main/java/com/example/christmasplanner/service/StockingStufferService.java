package com.example.christmasplanner.service;

import com.example.christmasplanner.model.StockingStuffer;
import com.example.christmasplanner.repository.StockingStufferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
