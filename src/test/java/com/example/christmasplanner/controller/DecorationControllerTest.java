package com.example.christmasplanner.controller;

import com.example.christmasplanner.model.Decoration;
import com.example.christmasplanner.service.DecorationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Optional;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.ArgumentMatchers.anyLong;


@WebMvcTest(DecorationController.class)
public class DecorationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DecorationService decorationService;

    @Autowired
    ObjectMapper objectMapper;

    Decoration DECORATION_1 = new Decoration(1L, "Gingerbread House Village", "Gingerbread cookies, royal icing, candies, small figurines", "Decorate gingerbread houses and arrange them alongside small figurines to complete the village look.", "https://busybeingjennifer.com/wp-content/uploads/2018/10/DSC_0136-1024x759.jpg");

    Decoration DECORATION_2 = new Decoration(2L, "Candy Cane Wreath", "Red and white candy canes, ribbon", "Craft a wreath by securing red and white candy canes in a circular shape using ribbon. Hang it on your door or wall for a sweet and simple decoration.", "https://www.poughkeepsiejournal.com/gcdn/presto/2021/12/03/PWES/22497a9a-77f0-4d4e-a821-2bb0de89cef6-20211127_171627.jpg?crop=3914,2202,x0,y161&width=660&height=372&format=pjpg&auto=webp");

    Decoration DECORATION_3 = new Decoration(3L, "Floating Candle Centerpiece", "Clear glass vases or bowls, water, floating candles, holly leaves, cranberries", "Fill clear glass vases or bowls with water, add floating candles, and garnish with holly leaves and cranberries.", "https://i1.wp.com/www.thinkmakeshareblog.com/wp-content/uploads/Snowglobe-Workshop-_-thinkmakeshareblog-4.jpg?w=822&ssl=1");


    /**
     * This test says that when we call decorationService.getAllDecorations(), then to return all decorations.
     * Use mockMvc to perform a GET request to the endpoint ("/api/decorations/"), set the content type you're expecting, which is MediaType.APPLICATION_JSON. Expect the response status to be ok. Expect the jsonPath of the 'data' key of the payload to have a size of 3. Expect the jsonPath of the 'message' key of the payload to have a value of 'success'. Then print the message.
     *
     * @throws Exception if list of decorations not found
     */
    @Test
    public void getAllDecorationRecords_success() throws Exception {
        List<Decoration> decorationList = new ArrayList<>(Arrays.asList(DECORATION_1, DECORATION_2, DECORATION_3));

        when(decorationService.getAllDecorations()).thenReturn(decorationList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/decorations/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                // jsonPath helps us check that we have a data key and a message key. '$' represents the payload
                .andExpect(jsonPath("$.data", hasSize(3)))
                .andExpect(jsonPath("$.message").value("success"))
                .andDo(print());
    }

    /**
     * This test says that when we call decorationService.getDecorationById(), then to return an optional of the decoration if it exists.
     * Perform a GET request to the endpoint and uri variable ("/api/decorations/{id}/", "1"), then set the content type you're expecting, which is MediaType.APPLICATION_JSON. Expect the response status to be ok. Expect the jsonPath of the attributes in the payload to be equal to the value of the get method for that attribute. Expect the jsonPath of the 'message' key of the payload to have a value of 'success'. Then print the message.
     *
     * @throws Exception if decoration not found
     */
    @Test
    public void getDecorationRecord_success() throws Exception {

        when(decorationService.getDecorationById(DECORATION_1.getId())).thenReturn(Optional.of(DECORATION_1));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/decorations/{id}/", "1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(DECORATION_1.getId()))
                .andExpect(jsonPath("$.data.name").value(DECORATION_1.getName()))
                .andExpect(jsonPath("$.data.materials").value(DECORATION_1.getMaterials()))
                .andExpect(jsonPath("$.data.directions").value(DECORATION_1.getDirections()))
                .andExpect(jsonPath("$.data.image").value(DECORATION_1.getImage()))
                .andExpect(jsonPath("$.message").value("success"))
                .andDo(print());
    }

    /**
     *
     * This test says that when we call decorationService.createDecoration(), create a mock of any Decoration, then return the decoration.
     * Create a mock request and set it equal to calling a POST request to the endpoint ("/api/decorations/"), then set the content type you're expecting, which is MediaType.APPLICATION_JSON. Accept the content and convert it from Java to JSON, then write the value of the decoration's record as a string.
     * Perform the mock request and expect the response status to be isCreated. Expect the jsonPath of the payload and a not null value. Expect the jsonPath of the attributes in the payload to be equal to the value of the get method for that attribute. Expect the jsonPath of the 'message' key of the payload to have a value of 'success'. Then print the message.
     *
     * @throws Exception if decoration already exists
     */
    @Test
    public void createDecorationRecord_success() throws Exception {

        when(decorationService.createDecoration(Mockito.any(Decoration.class))).thenReturn(DECORATION_1);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/decorations/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(DECORATION_1));

        mockMvc.perform(mockRequest)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.data.id").value(DECORATION_1.getId()))
                .andExpect(jsonPath("$.data.name").value(DECORATION_1.getName()))
                .andExpect(jsonPath("$.data.materials").value(DECORATION_1.getMaterials()))
                .andExpect(jsonPath("$.data.directions").value(DECORATION_1.getDirections()))
                .andExpect(jsonPath("$.data.image").value(DECORATION_1.getImage()))
                .andExpect(jsonPath("$.message").value("success"))
                .andDo(print());
    }

    /**
     * This test says that when we call decorationService.updateDecoration() in instances where the decoration is not found, to create a mock of any Decoration and then return an empty optional.
     * Create a mock request and set it equal to calling a DELETE request to the endpoint and uri variable ("/api/decorations/{id}/", 1L). Then set the content type you're expecting, which is 'MediaType.APPLICATION_JSON', and accept it.
     * Perform the mock request and expect the response status to be not found. Expect the jsonPath of the payload and a not null value. And expect the jsonPath of the 'message' key of the payload to have a value of 'cannot find decoration with id 1'. Then print the message.
     *
     * @throws Exception if decoration not found
     */
    @Test
    public void updateDecorationRecord_recordNotFound() throws Exception {

        when(decorationService.updateDecoration(anyLong(), Mockito.any(Decoration.class))).thenReturn(Optional.empty());

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.delete("/api/decorations/{id}/", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(mockRequest)
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.message").value("decoration with id 1 not found"))
                .andDo(print());
    }

    /**
     * This test says that when we call decorationService.updateDecoration() in successful instances where the decoration is found, to create a mock of any decoration, then return the updated decoration if it exists.
     * Create a mock request and set it equal to calling a PUT request to the endpoint and uri variable ("/api/decorations/{id}/", 1L). Then set the content type you're expecting, which is 'MediaType.APPLICATION_JSON'. Accept the content and convert it from Java to JSON, then write the value of the decoration object as a string.
     * Perform the mock request and expect the response status to be ok. Expect the jsonPath of the payload and a not null value. Expect the jsonPath of the attributes in the payload to be equal to the value of the get method for that attribute. And expect the jsonPath of the 'message' key of the payload to have a value of 'success'. Then print the message.
     *
     * @throws Exception if decoration not found
     */
    @Test
    public void updateDecorationRecord_success() throws Exception {

        Long decorationId = 1L;
        Decoration decoration = new Decoration(decorationId, "original name", "original materials", "original description", "https://inhabitat.com/wp-content/blogs.dir/1/files/2013/11/Orange-pomander-centerpiece.jpg");
        Decoration updatedDecoration = new Decoration(decorationId, "updated name", "updated materials", "updated description", "https://m.media-amazon.com/images/I/81z16eqUOfL._AC_SX679_.jpg");

        when(decorationService.updateDecoration(anyLong(), Mockito.any(Decoration.class))).thenReturn(Optional.of(updatedDecoration));

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/api/decorations/{id}/", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(decoration));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.data.id").value(updatedDecoration.getId()))
                .andExpect(jsonPath("$.data.name").value(updatedDecoration.getName()))
                .andExpect(jsonPath("$.data.materials").value(updatedDecoration.getMaterials()))
                .andExpect(jsonPath("$.data.directions").value(updatedDecoration.getDirections()))
                .andExpect(jsonPath("$.data.image").value(updatedDecoration.getImage()))
                .andExpect(jsonPath("$.message").value("success"))
                .andDo(print());
    }

}
