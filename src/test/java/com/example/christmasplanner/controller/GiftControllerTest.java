package com.example.christmasplanner.controller;

import com.example.christmasplanner.model.Gift;
import com.example.christmasplanner.service.GiftService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(GiftController.class)
public class GiftControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GiftService giftService;

    @Autowired
    ObjectMapper objectMapper;


    Gift GIFT_1 = new Gift(1L, "Custom Knit or Crochet Gifts", "Knit or crochet cozy scarves, mittens, or blankets in holiday colors. Handmade, warm gifts for the winter season.");
    Gift GIFT_2 = new Gift(1L, "Homemade Peppermint Bath Bombs", "Craft peppermint-scented bath bombs with natural ingredients. Package them in festive containers for a relaxing bath experience.");
    Gift GIFT_3 = new Gift(1L, "Homemade Potpourri Sachets", "Mix dried citrus slices, cinnamon sticks, cloves, and pinecones to create fragrant potpourri sachets. Bundle them in decorative fabric.");


    /**
     * This test says that when we call giftService.getAllGifts(), then to return all gifts.
     * Use mockMvc to perform a GET request to the endpoint ("/api/gifts/"), set the content type you're expecting, which is MediaType.APPLICATION_JSON. Expect the response status to be ok. Expect the jsonPath of the 'data' key of the payload to have a size of 2. Expect the jsonPath of the 'message' key of the payload to have a value of 'success'. Then print the message.
     *
     * @throws Exception if list of gifts not found
     */
    @Test
    public void getAllGiftRecords_success() throws Exception {
        List<Gift> giftList = new ArrayList<>(Arrays.asList(GIFT_1, GIFT_2, GIFT_3));

        when(giftService.getAllGifts()).thenReturn(giftList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/gifts/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data", hasSize(2)))
                .andExpect(jsonPath("$.message").value("success"))
                .andDo(print());
    }

    @Test
    public void getGiftRecord_success() throws Exception {
        when(giftService.getGiftById(GIFT_1.getId()))
    }

}
