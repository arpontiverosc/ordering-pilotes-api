package com.tui.ordering.pilotes.in.rest.v1.model.response;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class DetailOrderResponse {

    private final String orderId;
    private final String deliveryAddress;
    private final int pilotesNumber;
    private final double orderTotal;
    private final DetailCustomerResponse customer;
}
