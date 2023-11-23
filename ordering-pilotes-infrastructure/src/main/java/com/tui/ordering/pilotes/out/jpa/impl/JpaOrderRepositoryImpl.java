package com.tui.ordering.pilotes.out.jpa.impl;

import com.tui.ordering.pilotes.model.Order;
import com.tui.ordering.pilotes.out.jpa.SpringDataOrderRepository;
import com.tui.ordering.pilotes.port.out.SaveOrderRepository;

public class JpaOrderRepositoryImpl implements SaveOrderRepository {

    private final SpringDataOrderRepository springDataOrderRepository;

    public JpaOrderRepositoryImpl(SpringDataOrderRepository springDataOrderRepository) {
        this.springDataOrderRepository = springDataOrderRepository;
    }

    @Override
    public Order save(Order order) {
        mapper
        springDataOrderRepository.save(order);
    }
}
