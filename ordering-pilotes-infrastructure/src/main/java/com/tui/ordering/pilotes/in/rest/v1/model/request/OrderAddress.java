package com.tui.ordering.pilotes.in.rest.v1.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import com.tui.ordering.pilotes.util.OrderErrorCode;


@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderAddress {

    @NotNull(message = OrderErrorCode.ADDRESS_STREET_MANDATORY)
    private final String street;

    @NotNull(message = OrderErrorCode.ADDRESS_POSTCODE_MANDATORY)
    private final String postcode;

    @NotNull(message = OrderErrorCode.ADDRESS_CITY_MANDATORY)
    private final String city;

    @NotNull(message = OrderErrorCode.ADDRESS_CODE_MANDATORY)
    private final String country;
}
