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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(DecorationController.class)
public class DecorationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DecorationService decorationService;

    @Autowired
    ObjectMapper objectMapper;

    Decoration DECORATION_1 = new Decoration(1L, "Gingerbread House Village", "Gingerbread cookies, royal icing, candies, small figurines", "Create a charming gingerbread house village as a centerpiece on your kitchen counter or dining table. Decorate gingerbread houses and arrange them alongside small figurines to complete the village look.");

    Decoration DECORATION_2 = new Decoration(2L, "Candy Cane Wreath", "Red and white candy canes, ribbon", "Craft a wreath by securing red and white candy canes in a circular shape using ribbon. Hang it on your door or wall for a sweet and simple decoration.");

    Decoration DECORATION_3 = new Decoration(3L, "Floating Candle Centerpiece", "Clear glass vases or bowls, water, floating candles, holly leaves, cranberries", "Fill clear glass vases or bowls with water, add floating candles, and garnish with holly leaves and cranberries for a beautiful and elegant centerpiece.");


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



}
