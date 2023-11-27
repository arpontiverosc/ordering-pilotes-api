package com.tui.ordering.pilotes.mother;

import com.tui.ordering.pilotes.port.in.model.OrderAddress;
import com.tui.ordering.pilotes.port.in.model.UpdateOrderCommand;

public class UpdateOrderCommandMother {
    public static UpdateOrderCommand create() {

        return UpdateOrderCommand.Builder.builder()
                .orderId("472bd97a-e744-4f40-9b14-159dc1881591")
                .email("example@gmail.com")
                .deliveryAddress(OrderAddressMother.create())
                .pilotes(10)
                .userIdentifier("1011")
                .build();
    }
}
