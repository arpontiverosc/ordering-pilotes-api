package com.tui.ordering.pilotes.out.jpa.merger;

import com.tui.ordering.pilotes.model.Address;
import com.tui.ordering.pilotes.model.Order;
import com.tui.ordering.pilotes.out.jpa.model.AddressEntity;
import com.tui.ordering.pilotes.out.jpa.model.OrderEntity;

public class OrderJpaEntityMerger {

    private static void from(Address deliveryAddress, AddressEntity addressToSave) {
        addressToSave.setId(deliveryAddress.getAddressId());
        addressToSave.setCity(deliveryAddress.getCity());
        addressToSave.setStreet(deliveryAddress.getStreet());
        addressToSave.setPostcode(deliveryAddress.getPostcode());
    }

    public static void from(Order order, OrderEntity orderToSave) {
        orderToSave.setOrderId(order.getOrderId());
        orderToSave.setUserIdentifier(order.getUserIdentier());

        AddressEntity addressEntity = orderToSave.getDeliveryAddress();
        from(order.getDeliveryAddress(), addressEntity);
        orderToSave.setDeliveryAddress(addressEntity);

        orderToSave.setPilotes(order.getPilotes());
        orderToSave.setOrderTotal(order.getOrderTotal());
    }
}
