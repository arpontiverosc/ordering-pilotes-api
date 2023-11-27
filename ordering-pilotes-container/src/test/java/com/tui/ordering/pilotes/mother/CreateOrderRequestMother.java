package com.tui.ordering.pilotes.mother;


import com.tui.ordering.pilotes.in.rest.v1.model.request.CreateOrderRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateOrderRequestMother {

    public static CreateOrderRequest create(){

        return CreateOrderRequest.builder()
                .deliveryAddress(OrderAddressMother.create())
                .email("example@gmail.com")
                .pilotesNumber(10)
                .userIdentifier("1011")
                .build();
    }

    public static CreateOrderRequest createNoUser(){

        return CreateOrderRequest.builder()
                .deliveryAddress(OrderAddressMother.create())
                .email("example@gmail.com")
                .pilotesNumber(10)
                .build();
    }

    public static CreateOrderRequest create_CustomerIsNotInDatabase(){

        return CreateOrderRequest.builder()
                .deliveryAddress(OrderAddressMother.create())
                .email("example@gmail.com")
                .pilotesNumber(10)
                .userIdentifier("1010")
                .build();
    }

    public static CreateOrderRequest create_InvalidPiloteNumber(){

        return CreateOrderRequest.builder()
                .deliveryAddress(OrderAddressMother.create())
                .email("example@gmail.com")
                .pilotesNumber(3)
                .userIdentifier("1010")
                .build();
    }

    public static CreateOrderRequest createNoPilotes() {

        return CreateOrderRequest.builder()
                .deliveryAddress(OrderAddressMother.create())
                .email("example@gmail.com")
                .userIdentifier("1010")
                .build();
    }

    public static CreateOrderRequest createNoEmail() {

        return CreateOrderRequest.builder()
                .deliveryAddress(OrderAddressMother.create())
                .pilotesNumber(10)
                .userIdentifier("1011")
                .build();
    }
}
