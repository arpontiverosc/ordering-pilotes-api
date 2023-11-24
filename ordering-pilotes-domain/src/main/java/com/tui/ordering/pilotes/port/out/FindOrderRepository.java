package com.tui.ordering.pilotes.port.out;

import com.tui.ordering.pilotes.model.Order;

import java.util.Optional;

public interface FindOrderRepository {
    Optional<Order> findById(String orderId);
}
