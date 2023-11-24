package com.tui.ordering.pilotes.exception;

import com.tui.ordering.pilotes.util.OrderErrorCode;
import com.tui.ordering.pilotes.util.PiloteErrorCode;

public class OrderBeingCookingException extends BusinessValidationException {

  public OrderBeingCookingException() {
    super(OrderErrorCode.INVALID_STATUS);
  }
}
