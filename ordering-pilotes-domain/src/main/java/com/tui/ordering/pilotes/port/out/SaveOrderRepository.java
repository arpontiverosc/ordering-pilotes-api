package com.tui.ordering.pilotes.port.out;

import com.tui.ordering.pilotes.model.Order;

public interface SaveOrderRepository {
    Order save(Order order);
}
