package com.tui.ordering.pilotes.in.rest.v1.model.request;

import com.tui.ordering.pilotes.util.OrderErrorCode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderAddress {

    @NotBlank(message = OrderErrorCode.ADDRESS_STREET_MANDATORY)
    @Size(min = 3, message = OrderErrorCode.STREET_MIN_LENGTH)
    @Size(max = 25, message = OrderErrorCode.STREET_MAX_LENGTH)
    private final String street;


    @NotBlank(message = OrderErrorCode.ADDRESS_POSTCODE_MANDATORY)
    @Pattern(regexp = "\\d{5}", message = OrderErrorCode.POSTCODE_INVALID)
    private final String postcode;


    @NotBlank(message = OrderErrorCode.ADDRESS_CITY_MANDATORY)
    @Size(min = 3, message = OrderErrorCode.CITY_MIN_LENGTH)
    @Size(max = 25, message = OrderErrorCode.CITY_MAX_LENGTH)
    private final String city;


    @NotBlank(message = OrderErrorCode.ADDRESS_CODE_MANDATORY)
    @Size(min = 3, message = OrderErrorCode.COUNTRY_MIN_LENGTH)
    @Size(max = 25, message = OrderErrorCode.COUNTRY_MAX_LENGTH)
    private final String country;
}
