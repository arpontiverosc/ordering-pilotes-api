package com.tui.ordering.pilotes.in.rest.v1.mapper.response;

import com.tui.ordering.pilotes.in.rest.v1.model.response.DetailCustomerResponse;
import com.tui.ordering.pilotes.model.Customer;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DetailCustomerResponseMapper {
    public static DetailCustomerResponse from(Customer customer) {
        return DetailCustomerResponse.builder()
                .id(customer.getCustomerId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .build();
    }
}
