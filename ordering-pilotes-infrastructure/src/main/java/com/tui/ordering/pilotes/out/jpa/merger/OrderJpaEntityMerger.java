package com.tui.ordering.pilotes.out.jpa.merger;

import com.tui.ordering.pilotes.model.Address;
import com.tui.ordering.pilotes.model.Order;
import com.tui.ordering.pilotes.out.jpa.model.AddressEntity;
import com.tui.ordering.pilotes.out.jpa.model.OrderEntity;

import java.time.OffsetDateTime;
import java.util.Objects;

public class OrderJpaEntityMerger {

    private static void from(Address deliveryAddress, AddressEntity addressToSave) {
        addressToSave.setId(deliveryAddress.getAddressId());
        addressToSave.setCity(deliveryAddress.getCity());
        addressToSave.setStreet(deliveryAddress.getStreet());
        addressToSave.setPostcode(deliveryAddress.getPostcode());
        addressToSave.setCountry(deliveryAddress.getCountry());
    }

    public static void from(Order order, OrderEntity orderToSave) {
        if(Objects.isNull(orderToSave.getCreatedAt())){
            orderToSave.setCreatedAt(OffsetDateTime.now());
        }
        orderToSave.setOrderId(order.getOrderId());
        orderToSave.setUserIdentifier(order.getUserIdentier());

        AddressEntity addressEntity = orderToSave.getDeliveryAddress();
        if(Objects.isNull(addressEntity)){
            addressEntity = new AddressEntity();
        }
        from(order.getDeliveryAddress(), addressEntity);
        orderToSave.setDeliveryAddress(addressEntity);

        orderToSave.setPilotesNumber(order.getPilotesNumber());
        orderToSave.setOrderTotal(order.getOrderTotal());
    }
}
