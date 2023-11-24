package com.tui.ordering.pilotes.port.in;

import com.tui.ordering.pilotes.model.Order;

import java.util.List;

public interface SearchOrdersUseCase {
    List<Order> execute(String search);
}
