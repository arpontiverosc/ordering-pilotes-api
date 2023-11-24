package com.tui.ordering.pilotes.out.jpa.mapper;


import com.tui.ordering.pilotes.model.Order;
import com.tui.ordering.pilotes.out.jpa.model.OrderEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderMapper {

    public static Order from(OrderEntity orderEntity) {
        return Order.Builder.builder()
                .orderId(orderEntity.getOrderId())
                .pilotes(orderEntity.getPilotes())
                .orderTotal(orderEntity.getOrderTotal())
                .userIdentifier(orderEntity.getUserIdentifier())
                .deliveryAddress(AddressMapper.from(orderEntity.getDeliveryAddress()))
                .build();
    }


}
