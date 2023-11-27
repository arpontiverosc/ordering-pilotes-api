package com.tui.ordering.pilotes.in.rest.v1.mapper.query;

import com.tui.ordering.pilotes.in.rest.v1.model.request.SearchOrderRequest;
import com.tui.ordering.pilotes.port.in.model.SearchOrderQuery;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateSearchOrderQueryMapper {
    public static SearchOrderQuery from(SearchOrderRequest request) {
        return SearchOrderQuery.Builder.builder()
                .customerId(request.getCustomerId())
                .orderId(request.getOrderId())
                .customerFirstName(request.getCustomerFirstName())
                .customerLastName(request.getCustomerLastName())
                .pilotesNumber(request.getPilotesNumber())
                .build();
    }
}
