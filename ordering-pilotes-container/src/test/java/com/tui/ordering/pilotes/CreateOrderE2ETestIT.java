package com.tui.ordering.pilotes;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tui.ordering.pilotes.in.rest.v1.model.request.CreateOrderRequest;
import com.tui.ordering.pilotes.mother.CreateOrderRequestMother;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CreateOrderE2ETestIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createOrder_SuccessfullyTest() throws Exception {

        CreateOrderRequest createOrderRequest = CreateOrderRequestMother.create();

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/orders")
                        .content(objectMapper.writeValueAsString(createOrderRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.orderId").isNotEmpty())
                .andExpect(jsonPath("$.orderTotal").isNotEmpty())
                .andExpect(jsonPath("$.deliveryAddress").isNotEmpty())
                .andExpect(jsonPath("$.pilotesNumber").isNotEmpty())
                .andExpect(jsonPath("$.pilotesNumber").isNotEmpty())
                .andExpect(jsonPath("$.email").isNotEmpty())
                .andExpect(jsonPath("$.createdAt").isNotEmpty());

    }

    @Test
    void createOrder_UserMandatoryTest() throws Exception {

        CreateOrderRequest createOrderRequestNoUser = CreateOrderRequestMother.createNoUser();

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/orders")
                        .content(objectMapper.writeValueAsString(createOrderRequestNoUser))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void createOrder_PilotesMandatoryTest() throws Exception {

        CreateOrderRequest createOrderRequestNoUser = CreateOrderRequestMother.createNoPilotes();

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/orders")
                        .content(objectMapper.writeValueAsString(createOrderRequestNoUser))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void createOrder_EmailMandatoryTest() throws Exception {

        CreateOrderRequest createOrderRequestNoUser = CreateOrderRequestMother.createNoEmail();

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/orders")
                        .content(objectMapper.writeValueAsString(createOrderRequestNoUser))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void createOrder_ClientNotFoundExceptionTest() throws Exception {

        CreateOrderRequest createOrderRequest = CreateOrderRequestMother.create_CustomerIsNotInDatabase();

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/orders")
                        .content(objectMapper.writeValueAsString(createOrderRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error").value("Not Found"))
                .andExpect(jsonPath("$.detail").value("client.notFound"));

    }


    @Test
    void createOrder_PiloteInvalidNumberExceptionTest() throws Exception {

        CreateOrderRequest createOrderRequest = CreateOrderRequestMother.create_InvalidPiloteNumber();

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/orders")
                        .content(objectMapper.writeValueAsString(createOrderRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.error").value("Unprocessable Entity"))
                .andExpect(jsonPath("$.detail").value("pilote.invalid.value"));

    }





}
