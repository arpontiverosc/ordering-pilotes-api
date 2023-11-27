package com.tui.ordering.pilotes.mother;

import com.tui.ordering.pilotes.port.in.model.CreateOrderCommand;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateOrderCommandMother {

    public static CreateOrderCommand create(){
        return CreateOrderCommand.Builder.builder()
                .deliveryAddress(OrderAddressMother.create())
                .email("example@gmail.com")
                .pilotes(10)
                .userIdentifier("1011")
                .build();
    }

}
