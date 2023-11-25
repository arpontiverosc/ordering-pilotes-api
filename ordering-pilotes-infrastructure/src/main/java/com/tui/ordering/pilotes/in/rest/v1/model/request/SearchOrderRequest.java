package com.tui.ordering.pilotes.in.rest.v1.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class SearchOrderRequest {

    private final String orderId;
    private final int pilotesNumber;
    private final String customerId;
    private final String customerFirstName;
    private final String customerLastName;

}
