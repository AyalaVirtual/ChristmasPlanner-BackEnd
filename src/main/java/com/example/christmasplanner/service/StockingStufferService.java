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


    /**
     * This is a GET request that checks to see if the list of stocking stuffers is empty before either throwing an InformationNotFoundException, or  returning the list of stocking stuffers
     *
     * @return a list of all stocking stuffers
     */
    public List<StockingStuffer> getAllStockingStuffers() {
        return stockingStufferRepository.findAll();
    }


    /**
     * This is a GET request that checks to see if an individual stocking stuffer exists before either returning it, or throwing an InformationNotFoundException
     *
     * @param stockingStufferId represents the id of the specific stocking stuffer the user is trying to get
     * @return stocking stuffer by id if it exists
     */
    public Optional<StockingStuffer> getStockingStufferById(Long stockingStufferId) {
        Optional<StockingStuffer> stockingStufferOptional = stockingStufferRepository.findById(stockingStufferId);

        if (stockingStufferOptional.isPresent()) {
            return stockingStufferOptional;
        } else {
            throw new InformationNotFoundException("stocking stuffer with id " + stockingStufferId + " not found");
        }
    }

    public StockingStuffer createStockingStuffer(StockingStuffer stockingStufferObject) {
        StockingStuffer stockingStuffer = stockingStufferRepository.findByName(stockingStufferObject.getName());

        if (stockingStuffer != null) {
            throw new InformationExistException("stocking stuffer with name " + stockingStufferObject.getName() + " already exists");
        } else {
            stockingStufferRepository.save(stockingStufferObject);
            return stockingStufferObject;
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

    public Optional<StockingStuffer> deleteStockingStuffer(Long stockingStufferId) {
        Optional<StockingStuffer> stockingStufferOptional = stockingStufferRepository.findById(stockingStufferId);

        if (stockingStufferOptional.isPresent()) {
            stockingStufferRepository.deleteById(stockingStufferId);
            return stockingStufferOptional;
        } else {
            throw new InformationNotFoundException("stocking stuffer with id " + stockingStufferId + " not found");
        }
    }

}
