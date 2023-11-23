package com.tui.ordering.pilotes.in.rest.v1.model.response;

import lombok.*;


@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CreateOrderResponse {


    private final String orderId;
    private final String deliveryAddress;
    private final int pilotes;
    private final double orderTotal;

}
