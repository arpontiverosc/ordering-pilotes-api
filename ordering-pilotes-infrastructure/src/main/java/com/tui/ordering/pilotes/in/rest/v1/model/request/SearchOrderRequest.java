package com.tui.ordering.pilotes.in.rest.v1.model.request;

import com.tui.ordering.pilotes.util.OrderErrorCode;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class SearchOrderRequest {

    @Size(
            min = 1,
            message = OrderErrorCode.ORDER_ID_MIN_LENGTH)
    @Size(
            max = 50,
            message = OrderErrorCode.ORDER_ID_MAX_LENGTH)
    private final String orderId;

    private final Integer pilotesNumber;

    @Size(
            min = 1,
            message = OrderErrorCode.CUSTOMER_ID_MIN_LENGTH)
    @Size(
            max = 50,
            message = OrderErrorCode.CUSTOMER_ID_MAX_LENGTH)
    private final String customerId;

    @Size(
            min = 1,
            message = OrderErrorCode.FIRST_NAME_MIN_LENGTH)
    @Size(
            max = 25,
            message = OrderErrorCode.FIRST_NAME_MAX_LENGTH)
    private final String customerFirstName;

    @Size(
            min = 1,
            message = OrderErrorCode.LAST_NAME_MIN_LENGTH)
    @Size(
            max = 25,
            message = OrderErrorCode.LAST_NAME_MAX_LENGTH)
    private final String customerLastName;

}
