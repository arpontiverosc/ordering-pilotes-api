package com.tui.ordering.pilotes.in.rest.v1.model.request;

import com.tui.ordering.pilotes.util.OrderErrorCode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class UpdateOrderRequest {

    @NotBlank(message = OrderErrorCode.USER_IDENTIFIER_MANDATORY)
    private final String userIdentifier;

    @NotBlank(message = OrderErrorCode.DELIVERY_ADDRESS_MANDATORY)
    private final OrderAddress deliveryAddress;

    @NotBlank(message = OrderErrorCode.PILOTES_NUMBER_MANDATORY)
    private final Integer pilotesNumber;
}
