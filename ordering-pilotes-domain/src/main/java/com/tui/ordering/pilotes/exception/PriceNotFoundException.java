package com.tui.ordering.pilotes.exception;

import com.tui.ordering.pilotes.util.PriceErrorCode;


public class PriceNotFoundException extends NotFoundException {

    public PriceNotFoundException() {
        super(PriceErrorCode.NOT_FOUND);
    }
}
