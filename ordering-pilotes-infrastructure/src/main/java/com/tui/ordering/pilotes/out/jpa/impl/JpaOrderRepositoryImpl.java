package com.tui.ordering.pilotes.out.jpa.impl;

import com.tui.ordering.pilotes.model.Order;
import com.tui.ordering.pilotes.out.jpa.SpringDataOrderRepository;
import com.tui.ordering.pilotes.out.jpa.mapper.OrderMapper;
import com.tui.ordering.pilotes.out.jpa.merger.OrderJpaEntityMerger;
import com.tui.ordering.pilotes.out.jpa.model.OrderEntity;
import com.tui.ordering.pilotes.port.out.SaveOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JpaOrderRepositoryImpl implements SaveOrderRepository {

    private final SpringDataOrderRepository springDataOrderRepository;

    @Override
    public Order save(Order order) {
        OrderEntity orderToSave = springDataOrderRepository.findById(order.getOrderId()).orElseGet(OrderEntity::new);
        OrderJpaEntityMerger.from(order, orderToSave);
        return OrderMapper.from(springDataOrderRepository.save(orderToSave));
    }

}
