package com.tui.ordering.pilotes.port.in;

import com.tui.ordering.pilotes.port.in.model.UpdateOrderCommand;

public interface UpdateOrderUseCase {
    void execute(UpdateOrderCommand command);
}
