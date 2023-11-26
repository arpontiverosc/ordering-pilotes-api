package com.tui.ordering.pilotes.in.rest.v1.model.response;

import lombok.*;

import java.time.OffsetDateTime;


@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CreateOrderResponse {


    private final String orderId;
    private final String deliveryAddress;
    private final int pilotesNumber;
    private final double orderTotal;
    private final String userIdentifier;
    private final OffsetDateTime createdAt;
    private final String email;

}
