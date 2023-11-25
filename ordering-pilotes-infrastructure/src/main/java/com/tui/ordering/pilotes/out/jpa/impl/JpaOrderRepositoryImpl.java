package com.tui.ordering.pilotes.out.jpa.impl;

import com.tui.ordering.pilotes.model.Order;
import com.tui.ordering.pilotes.out.jpa.SpringDataCustomerRepository;
import com.tui.ordering.pilotes.out.jpa.SpringDataOrderRepository;
import com.tui.ordering.pilotes.out.jpa.impl.spec.OrderSpecification;
import com.tui.ordering.pilotes.out.jpa.mapper.OrderMapper;
import com.tui.ordering.pilotes.out.jpa.merger.OrderJpaEntityMerger;
import com.tui.ordering.pilotes.out.jpa.model.CustomerEntity;
import com.tui.ordering.pilotes.out.jpa.model.OrderEntity;
import com.tui.ordering.pilotes.port.in.model.SearchOrderQuery;
import com.tui.ordering.pilotes.port.out.FindOrderRepository;
import com.tui.ordering.pilotes.port.out.SaveOrderRepository;
import com.tui.ordering.pilotes.port.out.SearchOrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaOrderRepositoryImpl implements SaveOrderRepository, FindOrderRepository, SearchOrdersRepository {

    private final SpringDataOrderRepository springDataOrderRepository;
    private final SpringDataCustomerRepository springDataCustomerRepository;

    private void updateCustomer(Order order, OrderEntity orderToSave){
        Optional<CustomerEntity> customerEntity = springDataCustomerRepository.findById(order.getCustomer().getCustomerId());
        customerEntity.ifPresent(orderToSave::setCustomer);
    }

    @Override
    public Order save(Order order) {
        OrderEntity orderToSave = springDataOrderRepository.findById(order.getOrderId()).orElseGet(OrderEntity::new);
        OrderJpaEntityMerger.from(order, orderToSave);
        updateCustomer(order, orderToSave);
        return OrderMapper.from(springDataOrderRepository.save(orderToSave));
    }

    @Override
    public List<Order> searchBy(SearchOrderQuery query) {
        Optional<Specification<OrderEntity>> where = OrderSpecification.where(query);
        List<OrderEntity> orders = where.map(springDataOrderRepository::findAll).orElseGet(springDataOrderRepository::findAll);
        return orders.stream().map(OrderMapper::from).toList();
    }

    @Override
    public Optional<Order> findById(String orderId) {
        return springDataOrderRepository.findById(orderId).map(OrderMapper::from);
    }
}
