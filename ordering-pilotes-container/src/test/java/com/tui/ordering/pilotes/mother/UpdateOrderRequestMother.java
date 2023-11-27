package com.tui.ordering.pilotes.mother;

import com.tui.ordering.pilotes.in.rest.v1.model.request.OrderAddress;
import com.tui.ordering.pilotes.in.rest.v1.model.request.UpdateOrderRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UpdateOrderRequestMother {

    public static UpdateOrderRequest create(){

        return UpdateOrderRequest.builder()
                .deliveryAddress(OrderAddressMother.createChanged())
                .email("exampleChanged@gmail.com")
                .pilotesNumber(15)
                .userIdentifier("1012")
                .build();

    }

    public static UpdateOrderRequest create_CustomerIsNotInDatabase(){

        return UpdateOrderRequest.builder()
                .deliveryAddress(OrderAddressMother.create())
                .email("exampleChanged@gmail.com")
                .pilotesNumber(15)
                .userIdentifier("1009")
                .build();

    }

    public static UpdateOrderRequest create_InvalidPiloteNumber(){

        return UpdateOrderRequest.builder()
                .deliveryAddress(OrderAddressMother.create())
                .email("exampleChanged@gmail.com")
                .pilotesNumber(3)
                .userIdentifier("1012")
                .build();

    }
}
