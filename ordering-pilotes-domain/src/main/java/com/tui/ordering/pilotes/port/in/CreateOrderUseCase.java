package com.tui.ordering.pilotes.port.in;

import com.tui.ordering.pilotes.model.Order;
import com.tui.ordering.pilotes.port.in.model.CreateOrderCommand;

public interface CreateOrderUseCase {

    Order execute(CreateOrderCommand from);
}
