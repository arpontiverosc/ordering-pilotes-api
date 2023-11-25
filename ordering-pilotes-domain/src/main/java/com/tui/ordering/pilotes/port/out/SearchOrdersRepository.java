package com.tui.ordering.pilotes.port.out;

import com.tui.ordering.pilotes.model.Order;
import com.tui.ordering.pilotes.port.in.model.SearchOrderQuery;

import java.util.List;

public interface SearchOrdersRepository {
    List<Order> searchBy(SearchOrderQuery query);
}
