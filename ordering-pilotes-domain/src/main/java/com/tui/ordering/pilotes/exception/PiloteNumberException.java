package com.tui.ordering.pilotes.exception;

import com.tui.ordering.pilotes.util.PiloteErrorCode;

public class PiloteNumberException extends BusinessValidationException {

  public PiloteNumberException() {
    super(PiloteErrorCode.INVALID_VALUE);
  }
}
