package com.tui.ordering.pilotes.in.rest.v1.mapper.response;

import com.tui.ordering.pilotes.in.rest.v1.model.response.DetailOrderResponse;
import com.tui.ordering.pilotes.model.Order;

public class DetailOrderResponseMapper {
    public static DetailOrderResponse from(Order order) {
        return DetailOrderResponse.builder()
                .orderId(order.getOrderId())
                .deliveryAddress(order.getDeliveryAddress().getAddressId())
                .pilotesNumber(order.getPilotesNumber())
                .orderTotal(order.getOrderTotal())
                .userIdentifier(order.getUserIdentier())
                .build();
    }
}
