package com.tui.ordering.pilotes.exception;

import com.tui.ordering.pilotes.util.TimeUpdatableErrorCode;


public class TimeUpdatableNotFoundException extends NotFoundException {

    public TimeUpdatableNotFoundException() {
        super(TimeUpdatableErrorCode.NOT_FOUND);
    }
}
