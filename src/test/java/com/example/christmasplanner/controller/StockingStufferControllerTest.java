package com.example.christmasplanner.controller;

import com.example.christmasplanner.model.StockingStuffer;
import com.example.christmasplanner.service.StockingStufferService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;


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


    /**
     * This test says that when we call stockingStufferService.getAllStockingStuffers(), then to return all stocking stuffers.
     * Use mockMvc to perform a GET request to the endpoint ("/api/stockingstuffers/"), set the content type you're expecting, which is MediaType.APPLICATION_JSON. Expect the response status to be ok. Expect the jsonPath of the 'data' key of the payload to have a size of 3. Expect the jsonPath of the 'message' key of the payload to have a value of 'success'. Then print the message.
     *
     * @throws Exception if list of stocking stuffers not found
     */
    @Test
    public void getAllStockingStufferRecords_success() throws Exception {
        List<StockingStuffer> stockingStufferList = new ArrayList<>(Arrays.asList(STOCKING_STUFFER_1, STOCKING_STUFFER_2, STOCKING_STUFFER_3));

        when(stockingStufferService.getAllStockingStuffers()).thenReturn(stockingStufferList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/stockingstuffers/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data", hasSize(3)))
                .andExpect(jsonPath("$.message").value("success"))
                .andDo(print());
    }


}
