package com.tui.ordering.pilotes.port.in;

import com.tui.ordering.pilotes.model.Order;
import com.tui.ordering.pilotes.port.in.model.SearchOrderQuery;

import java.util.List;

public interface SearchOrdersUseCase {
    List<Order> execute(SearchOrderQuery query);
}
