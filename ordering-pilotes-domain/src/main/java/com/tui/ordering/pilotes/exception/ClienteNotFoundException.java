package com.tui.ordering.pilotes.exception;

import com.tui.ordering.pilotes.util.ClientErrorCode;
public class ClienteNotFoundException extends NotFoundException {
    public ClienteNotFoundException() {
        super(ClientErrorCode.NOT_FOUND);
    }
}
