package com.tui.ordering.pilotes.in.rest.v1.mapper.response;

import com.tui.ordering.pilotes.in.rest.v1.model.response.DetailOrderResponse;
import com.tui.ordering.pilotes.model.Order;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DetailOrderResponseMapper {
    public static DetailOrderResponse from(Order order) {
        return DetailOrderResponse.builder()
                .orderId(order.getOrderId())
                .deliveryAddress(order.getDeliveryAddress().toString())
                .pilotesNumber(order.getPilotesNumber())
                .orderTotal(order.getOrderTotal())
                .customer(DetailCustomerResponseMapper.from(order.getCustomer()))
                .createAt(order.getCreatedAt())
                .email(order.getEmail())
                .build();
    }
}
