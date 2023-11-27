package com.tui.ordering.pilotes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tui.ordering.pilotes.in.rest.v1.model.request.CreateOrderRequest;
import com.tui.ordering.pilotes.in.rest.v1.model.request.UpdateOrderRequest;
import com.tui.ordering.pilotes.in.rest.v1.model.response.CreateOrderResponse;
import com.tui.ordering.pilotes.mother.CreateOrderRequestMother;
import com.tui.ordering.pilotes.mother.UpdateOrderRequestMother;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UpdateOrderE2ETestIT {

    private static final String ORDER_ID = "472bd97a-e744-4f40-9b14-159dc1881591";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void updateOrder_SuccessfullyTest() throws Exception {

        CreateOrderRequest createOrderRequest = CreateOrderRequestMother.create();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/v1/orders")
                        .content(objectMapper.writeValueAsString(createOrderRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        String contentAsString = result.getResponse().getContentAsString();
        CreateOrderResponse createOrderResponse = objectMapper.readValue(contentAsString, CreateOrderResponse.class);

        UpdateOrderRequest updateOrderRequest = UpdateOrderRequestMother.create();

        mockMvc.perform(MockMvcRequestBuilders.put("/v1/orders/"+createOrderResponse.getOrderId())
                        .content(objectMapper.writeValueAsString(updateOrderRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

    }

    @Test
    void updateOrder_OrderNotFoundTest() throws Exception {

        UpdateOrderRequest updateOrderRequest = UpdateOrderRequestMother.create();

        mockMvc.perform(MockMvcRequestBuilders.put("/v1/orders/notwanttobefound")
                        .content(objectMapper.writeValueAsString(updateOrderRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error").value("Not Found"))
                .andExpect(jsonPath("$.detail").value("order.notFound"));

    }

    @Test
    void updateOrder_ClientNotFoundExceptionTest() throws Exception {

        UpdateOrderRequest updateOrderRequest = UpdateOrderRequestMother.create_CustomerIsNotInDatabase();

        mockMvc.perform(MockMvcRequestBuilders.put("/v1/orders/"+ORDER_ID)
                        .content(objectMapper.writeValueAsString(updateOrderRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error").value("Not Found"))
                .andExpect(jsonPath("$.detail").value("client.notFound"));

    }

    @Test
    void updateOrder_NotUpdatableAfter5MinutesExceptionTest() throws Exception {

        UpdateOrderRequest updateOrderRequest = UpdateOrderRequestMother.create();

        mockMvc.perform(MockMvcRequestBuilders.put("/v1/orders/"+ORDER_ID)
                        .content(objectMapper.writeValueAsString(updateOrderRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.error").value("Unprocessable Entity"))
                .andExpect(jsonPath("$.detail").value("order.invalidStatus"));

    }

    @Test
    void createOrder_PiloteInvalidNumberExceptionTest() throws Exception {

        UpdateOrderRequest updateOrderRequest = UpdateOrderRequestMother.create_InvalidPiloteNumber();

        mockMvc.perform(MockMvcRequestBuilders.put("/v1/orders/"+ORDER_ID)
                        .content(objectMapper.writeValueAsString(updateOrderRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.error").value("Unprocessable Entity"))
                .andExpect(jsonPath("$.detail").value("pilote.invalid.value"));

    }

}
