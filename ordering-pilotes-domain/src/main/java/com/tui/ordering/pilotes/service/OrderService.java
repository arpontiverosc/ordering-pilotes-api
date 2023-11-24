package com.tui.ordering.pilotes.service;

import com.tui.ordering.pilotes.exception.OrderBeingCookingException;
import com.tui.ordering.pilotes.exception.OrderNotFoundException;
import com.tui.ordering.pilotes.model.Order;
import com.tui.ordering.pilotes.port.out.FindOrderRepository;

public class OrderService {

    private final FindOrderRepository findOrderRepository;

    public OrderService(FindOrderRepository findOrderRepository) {
        this.findOrderRepository = findOrderRepository;
    }

    public void isBefore(int minutes, String orderId) {
        Order order = findById(orderId);
        if (order.getCreatedAt().isAfter(order.getCreatedAt().plusMinutes(minutes))) {
            throw new OrderBeingCookingException();
        }
    }

    public Order findById(String orderId) {
        return findOrderRepository.findById(orderId).orElseThrow(OrderNotFoundException::new);
    }
}
