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

    /**
     * This test says that when we call stockingStufferService.getAuthorById(), then to return the stocking stuffer if it exists.
     * Perform a GET request to the endpoint and uri variable ("/api/stockingstuffers/{id}/", "1"), then set the content type you're expecting, which is MediaType.APPLICATION_JSON. Expect the response status to be ok. Expect the jsonPath of the attributes in the payload to be equal to the value of the get method for that attribute. Expect the jsonPath of the 'message' key of the payload to have a value of 'success'. Then print the message.
     *
     * @throws Exception if stocking stuffer not found
     */
    @Test
    public void getStockingStufferRecord_success() throws Exception {

        when(stockingStufferService.getStockingStufferById(STOCKING_STUFFER_1.getId())).thenReturn(Optional.of(STOCKING_STUFFER_1));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/stockingstuffers/{id}/", "1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(STOCKING_STUFFER_1.getId()))
                .andExpect(jsonPath("$.data.name").value(STOCKING_STUFFER_1.getName()))
                .andExpect(jsonPath("$.data.description").value(STOCKING_STUFFER_1))
                .andExpect(jsonPath("$.message").value("success"))
                .andDo(print());
    }

    /**
     *
     * This test says that when we call stockingStufferService.createStockingStuffer(), create a mock of any stocking stuffer, then return the stocking stuffer.
     * Create a mock request and set it equal to calling a POST request to the endpoint ("/api/stockingstuffers/"), then set the content type you're expecting, which is MediaType.APPLICATION_JSON. Accept the content and convert it from Java to JSON, then write the value of the stocking stuffer's record as a string.
     * Perform the mock request and expect the response status to be isCreated. Expect the jsonPath of the payload and a not null value. Expect the jsonPath of the attributes in the payload to be equal to the value of the get method for that attribute. Expect the jsonPath of the 'message' key of the payload to have a value of 'success'. Then print the message.
     *
     * @throws Exception if stocking stuffer already exists
     */
    @Test
    public void createStockingStufferRecord_success() throws Exception {

        when(stockingStufferService.createStockingStuffer(Mockito.any(StockingStuffer.class))).thenReturn(STOCKING_STUFFER_1);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/stockingstuffers/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(STOCKING_STUFFER_1));

        mockMvc.perform(mockRequest)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.data.id").value(STOCKING_STUFFER_1.getId()))
                .andExpect(jsonPath("$.data.name").value(STOCKING_STUFFER_1.getName()))
                .andExpect(jsonPath("$.data.description").value(STOCKING_STUFFER_1.getDescription()))
                .andExpect(jsonPath("$.message").value("success"))
                .andDo(print());
    }

    /**
     * This test says that when we call stockingStufferService.updateStockingStuffer() in instances where the stocking stuffer is not found, to create a mock of any stocking stuffer and then return an empty optional.
     * Create a mock request and set it equal to calling a DELETE request to the endpoint and uri variable ("/api/stockingstuffers/{id}/", 1L). Then set the content type you're expecting, which is 'MediaType.APPLICATION_JSON', and accept it.
     * Perform the mock request and expect the response status to be not found. Expect the jsonPath of the payload and a not null value. And expect the jsonPath of the 'message' key of the payload to have a value of 'cannot find stocking stuffer with id 1'. Then print the message.
     *
     * @throws Exception if stocking stuffer not found
     */
    @Test
    public void updateStockingStufferRecord_recordNotFound() throws Exception {

        when(stockingStufferService.updateStockingStuffer(anyLong(), Mockito.any(StockingStuffer.class))).thenReturn(Optional.empty());

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.delete("/api/stockingstuffers/{id}/", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(mockRequest)
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.message").value("stocking stuffer with id 1 not found"))
                .andDo(print());
    }

    /**
     * This test says that when we call stockingStufferService.updateStockingStuffer() in successful instances where the stocking stuffer is found, to create a mock of any stocking stuffer, then return the updated stocking stuffer if it exists.
     * Create a mock request and set it equal to calling a PUT request to the endpoint and uri variable ("/api/stockingstuffers/{id}/", 1L). Then set the content type you're expecting, which is 'MediaType.APPLICATION_JSON'. Accept the content and convert it from Java to JSON, then write the value of the stocking stuffer object as a string.
     * Perform the mock request and expect the response status to be ok. Expect the jsonPath of the payload and a not null value. Expect the jsonPath of the attributes in the payload to be equal to the value of the get method for that attribute. And expect the jsonPath of the 'message' key of the payload to have a value of 'success'. Then print the message.
     *
     * @throws Exception if  not stocking stuffer found
     */
    @Test
    public void updateStockingStufferRecord_success() throws Exception {
        Long stockingStufferId = 1L;
        StockingStuffer stockingStuffer = new StockingStuffer(stockingStufferId, "Original name", "Original description");
        StockingStuffer updatedStockingStuffer = new StockingStuffer(stockingStufferId, "Updated name", "Updated description");

        when(stockingStufferService.updateStockingStuffer(anyLong(), Mockito.any(StockingStuffer.class))).thenReturn(Optional.of(updatedStockingStuffer));

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/api/stockingstuffers/{id}/", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(stockingStuffer));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.data.id").value(updatedStockingStuffer.getId()))
                .andExpect(jsonPath("$.data.name").value(updatedStockingStuffer.getName()))
                .andExpect(jsonPath("$.data.description").value(updatedStockingStuffer.getDescription()))
                .andExpect(jsonPath("$.message").value("success"))
                .andDo(print());
    }

}
