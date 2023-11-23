package com.tui.ordering.pilotes.in.rest.v1.mapper.response;

import com.tui.ordering.pilotes.in.rest.v1.model.response.CreateOrderResponse;
import com.tui.ordering.pilotes.model.Order;

public class CreateOrderResponseMapper {
    public static CreateOrderResponse from(Order order) {
        return CreateOrderResponse.builder()
                .orderTotal(order.getOrderTotal())
                .deliveryAddress(order.getDeliveryAddress())
                .number(order.getNumber())
                .orderTotal(order.getOrderTotal())
                .build();
    }
}
