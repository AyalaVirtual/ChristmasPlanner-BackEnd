package com.example.christmasplanner.controller;

import com.example.christmasplanner.model.StockingStuffer;
import com.example.christmasplanner.service.StockingStufferService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@WebMvcTest(StockingStufferController.class)
public class StockingStufferControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StockingStufferService stockingStufferService;

    @Autowired
    ObjectMapper objectMapper;


    StockingStuffer STOCKING_STUFFER_1 = new StockingStuffer(1L, "Hand-Knit Fingerless Gloves", "Knit cozy fingerless gloves in festive colors for warmth and style during the winter.");
    StockingStuffer STOCKING_STUFFER_2 = new StockingStuffer(1L, "Homemade Peppermint Lip Scrub", "Whip up a peppermint lip scrub using sugar, coconut oil, and peppermint extract. Package it in small jars.");
    StockingStuffer STOCKING_STUFFER_3 = new StockingStuffer(1L, "Handcrafted Wood Slice Ornaments", "Paint and decorate wood slices with holiday designs to create rustic ornaments for the tree.");



}
