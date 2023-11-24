package com.tui.ordering.pilotes.in.rest.v1.model.request;

import com.tui.ordering.pilotes.util.OrderErrorCode;
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

    @NotNull(message = OrderErrorCode.USER_IDENTIFIER_MANDATORY)
    private final String userIdentifier;

    @NotNull(message = OrderErrorCode.DELIVERY_ADDRESS_MANDATORY)
    private final OrderAddress deliveryAddress;

    @NotNull(message = OrderErrorCode.PILOTES_NUMBER_MANDATORY)
    private final int pilotesNumber;
}
