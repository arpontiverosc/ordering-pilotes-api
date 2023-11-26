package com.tui.ordering.pilotes.in.rest.v1.mapper.command;

import com.tui.ordering.pilotes.in.rest.v1.model.request.UpdateOrderRequest;
import com.tui.ordering.pilotes.port.in.model.OrderAddress;
import com.tui.ordering.pilotes.port.in.model.UpdateOrderCommand;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UpdateOrderCommandMapper {
    public static UpdateOrderCommand from(String orderId, UpdateOrderRequest request){
        return UpdateOrderCommand.Builder.builder()
                .orderId(orderId)
                .userIdentifier(request.getUserIdentifier())
                .deliveryAddress(OrderAddress.Builder.builder()
                        .postcode(request.getDeliveryAddress().getPostcode())
                        .city(request.getDeliveryAddress().getCity())
                        .street(request.getDeliveryAddress().getStreet())
                        .country(request.getDeliveryAddress().getCountry())
                        .build())
                .email(request.getEmail())
                .pilotes(request.getPilotesNumber())
                .build();
    }

}
