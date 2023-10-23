package com.example.christmasplanner.controller;

import com.example.christmasplanner.model.Gift;
import com.example.christmasplanner.service.GiftService;
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


@WebMvcTest(GiftController.class)
public class GiftControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GiftService giftService;

    @Autowired
    ObjectMapper objectMapper;


    Gift GIFT_1 = new Gift(1L, "Custom Knit or Crochet Gifts", "Knit or crochet cozy scarves, mittens, or blankets in holiday colors. Handmade, warm gifts for the winter season.", "men, women, children, kids");
    Gift GIFT_2 = new Gift(1L, "Homemade Peppermint Bath Bombs", "Craft peppermint-scented bath bombs with natural ingredients. Package them in festive containers for a relaxing bath experience.", "women");
    Gift GIFT_3 = new Gift(1L, "Homemade Potpourri Sachets", "Mix dried citrus slices, cinnamon sticks, cloves, and pinecones to create fragrant potpourri sachets. Bundle them in decorative fabric.", "women, men");


    /**
     * This test says that when we call giftService.getAllGifts(), then to return all gifts.
     * Use mockMvc to perform a GET request to the endpoint ("/api/gifts/"), set the content type you're expecting, which is MediaType.APPLICATION_JSON. Expect the response status to be ok. Expect the jsonPath of the 'data' key of the payload to have a size of 3. Expect the jsonPath of the 'message' key of the payload to have a value of 'success'. Then print the message.
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
                .andExpect(jsonPath("$.data", hasSize(3)))
                .andExpect(jsonPath("$.message").value("success"))
                .andDo(print());
    }

    /**
     * This test says that when we call giftService.getGiftById(), then to return the gift if it exists.
     * Perform a GET request to the endpoint and uri variable ("/api/gifts/{id}/", "1"), then set the content type you're expecting, which is MediaType.APPLICATION_JSON. Expect the response status to be ok. Expect the jsonPath of the attributes in the payload to be equal to the value of the get method for that attribute. Expect the jsonPath of the 'message' key of the payload to have a value of 'success'. Then print the message.
     *
     * @throws Exception if gift not found
     */
    @Test
    public void getGiftRecord_success() throws Exception {

        when(giftService.getGiftById(GIFT_1.getId())).thenReturn(Optional.of(GIFT_1));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/gifts/{id}/", "1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(GIFT_1.getId()))
                .andExpect(jsonPath("$.data.name").value(GIFT_1.getName()))
                .andExpect(jsonPath("$.data.description").value(GIFT_1.getDescription()))
                .andExpect(jsonPath("$.data.tag").value(GIFT_1.getTag()))
                .andExpect(jsonPath("$.message").value("success"))
                .andDo(print());
    }

    /**
     *
     * This test says that when we call giftService.createGift(), create a mock of any gift, then return the gift.
     * Create a mock request and set it equal to calling a POST request to the endpoint ("/api/gifts/"), then set the content type you're expecting, which is MediaType.APPLICATION_JSON. Accept the content and convert it from Java to JSON, then write the value of the gift's record as a string.
     * Perform the mock request and expect the response status to be isCreated. Expect the jsonPath of the payload and a not null value. Expect the jsonPath of the attributes in the payload to be equal to the value of the get method for that attribute. Expect the jsonPath of the 'message' key of the payload to have a value of 'success'. Then print the message.
     *
     * @throws Exception if gift already exists
     */
    @Test
    public void createGiftRecord_success() throws Exception {

        when(giftService.createGift(Mockito.any(Gift.class))).thenReturn(GIFT_1);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/gifts/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(GIFT_1));

        mockMvc.perform(mockRequest)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.data.id").value(GIFT_1.getId()))
                .andExpect(jsonPath("$.data.name").value(GIFT_1.getName()))
                .andExpect(jsonPath("$.data.description").value(GIFT_1.getDescription()))
                .andExpect(jsonPath("$.data.tag").value(GIFT_1.getTag()))
                .andExpect(jsonPath("$.message").value("success"))
                .andDo(print());
    }

    /**
     * This test says that when we call giftService.updateGift() in instances where the gift is not found, to create a mock of any gift and then return an empty optional.
     * Create a mock request and set it equal to calling a DELETE request to the endpoint and uri variable ("/api/gifts/{id}/", 1L). Then set the content type you're expecting, which is 'MediaType.APPLICATION_JSON', and accept it.
     * Perform the mock request and expect the response status to be not found. Expect the jsonPath of the payload and a not null value. And expect the jsonPath of the 'message' key of the payload to have a value of 'cannot find gift with id 1'. Then print the message.
     *
     * @throws Exception if gift not found
     */
    @Test
    public void updateGiftRecord_recordNotFound() throws Exception {

        when(giftService.updateGift(anyLong(), Mockito.any(Gift.class))).thenReturn(Optional.empty());

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.delete("/api/gifts/{giftId}/", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(mockRequest)
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.message").value("gift with id 1 not found"))
                .andDo(print());
    }

    /**
     * This test says that when we call giftService.updateGift() in successful instances where the gift is found, to create a mock of any gift, then return the updated gift if it exists.
     * Create a mock request and set it equal to calling a PUT request to the endpoint and uri variable ("/api/gifts/{id}/", 1L). Then set the content type you're expecting, which is 'MediaType.APPLICATION_JSON'. Accept the content and convert it from Java to JSON, then write the value of the gift object as a string.
     * Perform the mock request and expect the response status to be ok. Expect the jsonPath of the payload and a not null value. Expect the jsonPath of the attributes in the payload to be equal to the value of the get method for that attribute. And expect the jsonPath of the 'message' key of the payload to have a value of 'success'. Then print the message.
     *
     * @throws Exception if gift not found
     */
    @Test
    public void updateGiftRecord_success() throws Exception {
        Long giftId = 1L;
        Gift gift = new Gift(giftId, "Original name", "Original desciption", "Original tag");
        Gift updatedGift = new Gift(giftId, "Updated name", "Updated description", "Updated tag");

        when(giftService.updateGift(anyLong(), Mockito.any(Gift.class))).thenReturn(Optional.of(updatedGift));

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/api/gifts/{id}/", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(gift));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.data.id").value(updatedGift.getId()))
                .andExpect(jsonPath("$.data.name").value(updatedGift.getName()))
                .andExpect(jsonPath("$.data.description").value(updatedGift.getDescription()))
                .andExpect(jsonPath("$.data.tag").value(updatedGift.getTag()))
                .andExpect(jsonPath("$.message").value("success"))
                .andDo(print());
    }

}
