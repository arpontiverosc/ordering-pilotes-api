package com.tui.ordering.pilotes.port.out;

import com.tui.ordering.pilotes.model.Order;

import java.util.List;

public interface SearchOrdersRepository {
    List<Order> searchBy(String searchQuery);
}
