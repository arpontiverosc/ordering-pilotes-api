package com.tui.ordering.pilotes.in.rest.v1.mapper.response;

import com.tui.ordering.pilotes.in.rest.v1.model.response.CreateOrderResponse;
import com.tui.ordering.pilotes.model.Address;
import com.tui.ordering.pilotes.model.Order;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateOrderResponseMapper {

    public static CreateOrderResponse from(Order order) {
        return CreateOrderResponse.builder()
                .orderTotal(order.getOrderTotal())
                .deliveryAddress(order.getDeliveryAddress().toString())
                .orderId(order.getOrderId()).orderTotal(order.getOrderTotal())
                .pilotesNumber(order.getPilotesNumber())
                .createdAt(order.getCreatedAt())
                .userIdentifier(order.getCustomer().getCustomerId())
                .email(order.getEmail())
                .build();
    }

}
