package com.tui.ordering.pilotes.exception;

import com.tui.ordering.pilotes.util.ClientErrorCode;
import com.tui.ordering.pilotes.util.OrderErrorCode;

public class OrderNotFoundException extends NotFoundException {
    public OrderNotFoundException() {
        super(OrderErrorCode.NOT_FOUND);
    }
}
