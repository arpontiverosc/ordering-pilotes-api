package com.tui.ordering.pilotes.in.rest.v1.mapper.command;

import com.tui.ordering.pilotes.in.rest.v1.model.request.CreateOrderRequest;
import com.tui.ordering.pilotes.port.in.model.CreateOrderCommand;
import com.tui.ordering.pilotes.port.in.model.OrderAddress;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateOrderCommandMapper {
    public static CreateOrderCommand from(CreateOrderRequest request) {
        return CreateOrderCommand.Builder.builder()
                .userIdentifier(request.getUserIdentifier())
                .deliveryAddress(OrderAddress.Builder.builder()
                                .postcode(request.getDeliveryAddress().getPostcode())
                                .city(request.getDeliveryAddress().getCity())
                                .street(request.getDeliveryAddress().getStreet())
                                .country(request.getDeliveryAddress().getCountry())
                                .build())
                .pilotes(request.getPilotes())
                .build();
    }

}
