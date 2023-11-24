package com.tui.ordering.pilotes.out.jpa.impl;

import com.tui.ordering.pilotes.model.Order;
import com.tui.ordering.pilotes.out.jpa.SpringDataOrderRepository;
import com.tui.ordering.pilotes.out.jpa.mapper.OrderMapper;
import com.tui.ordering.pilotes.out.jpa.merger.OrderJpaEntityMerger;
import com.tui.ordering.pilotes.out.jpa.model.OrderEntity;
import com.tui.ordering.pilotes.port.out.FindOrderRepository;
import com.tui.ordering.pilotes.port.out.SaveOrderRepository;
import com.tui.ordering.pilotes.port.out.SearchOrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaOrderRepositoryImpl implements SaveOrderRepository, FindOrderRepository, SearchOrdersRepository {

    private final SpringDataOrderRepository springDataOrderRepository;

    @Override
    public Order save(Order order) {
        OrderEntity orderToSave = springDataOrderRepository.findById(order.getOrderId()).orElseGet(OrderEntity::new);
        OrderJpaEntityMerger.from(order, orderToSave);
        return OrderMapper.from(springDataOrderRepository.save(orderToSave));
    }

    @Override
    public List<Order> searchBy(String searchQuery) {
        return null;
    }

    @Override
    public Optional<Order> findById(String orderId) {
        return springDataOrderRepository.findById(orderId).map(OrderMapper::from);
    }
}
