package com.tui.ordering.pilotes.out.jpa.mapper;


import com.tui.ordering.pilotes.model.Customer;
import com.tui.ordering.pilotes.model.Order;
import com.tui.ordering.pilotes.out.jpa.model.OrderEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderMapper {

    public static Order from(OrderEntity orderEntity) {
        return Order.Builder.builder()
                .orderId(orderEntity.getOrderId())
                .pilotes(orderEntity.getPilotesNumber())
                .orderTotal(orderEntity.getOrderTotal())
                .customer(Customer.Builder.builder()
                        .customerId(orderEntity.getCustomer().getId())
                        .firstName(orderEntity.getCustomer().getFirstName())
                        .lastName(orderEntity.getCustomer().getLastName())
                        .build())
                .deliveryAddress(AddressMapper.from(orderEntity.getDeliveryAddress()))
                .createdAt(orderEntity.getCreatedAt())
                .email(orderEntity.getEmail())
                .build();
    }

}
