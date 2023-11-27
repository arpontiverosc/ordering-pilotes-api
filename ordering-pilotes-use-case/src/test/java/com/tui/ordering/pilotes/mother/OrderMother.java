package com.tui.ordering.pilotes.mother;

import com.tui.ordering.pilotes.model.Address;
import com.tui.ordering.pilotes.model.Customer;
import com.tui.ordering.pilotes.model.Order;
import com.tui.ordering.pilotes.port.in.model.CreateOrderCommand;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderMother {
    public static Order createdAtOrderFrom(CreateOrderCommand command, Double price, OffsetDateTime date) {
        return Order.Builder.builder()
                .orderId(UUID.randomUUID().toString())
                .deliveryAddress(Address.Builder.builder()
                        .addressId(UUID.randomUUID().toString())
                        .postcode(command.getDeliveryAddress().getPostcode())
                        .city(command.getDeliveryAddress().getCity())
                        .street(command.getDeliveryAddress().getStreet())
                        .country(command.getDeliveryAddress().getCountry())
                        .postcode(command.getDeliveryAddress().getPostcode())
                        .build()
                )
                .customer(Customer.Builder.builder()
                        .customerId(command.getUserIdentifier())
                        .build())
                .pilotes(command.getPilotesNumber())
                .orderTotal(price*command.getPilotesNumber())
                .email(command.getEmail())
                .createdAt(date)
                .build();
    }

    public static Order createOrderFrom(CreateOrderCommand command, Double price) {
            return Order.Builder.builder()
                    .orderId(UUID.randomUUID().toString())
                    .deliveryAddress(Address.Builder.builder()
                            .addressId(UUID.randomUUID().toString())
                            .postcode(command.getDeliveryAddress().getPostcode())
                            .city(command.getDeliveryAddress().getCity())
                            .street(command.getDeliveryAddress().getStreet())
                            .country(command.getDeliveryAddress().getCountry())
                            .postcode(command.getDeliveryAddress().getPostcode())
                            .build()
                    )
                    .customer(Customer.Builder.builder()
                            .customerId(command.getUserIdentifier())
                            .build())
                    .pilotes(command.getPilotesNumber())
                    .orderTotal(price*command.getPilotesNumber())
                    .email(command.getEmail())
                    .build();
        }

}
