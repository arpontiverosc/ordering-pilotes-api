package com.tui.ordering.pilotes;

import com.tui.ordering.pilotes.model.Address;
import com.tui.ordering.pilotes.model.Customer;
import com.tui.ordering.pilotes.model.Order;
import com.tui.ordering.pilotes.port.in.CreateOrderUseCase;
import com.tui.ordering.pilotes.port.in.model.CreateOrderCommand;
import com.tui.ordering.pilotes.port.out.SaveOrderRepository;
import com.tui.ordering.pilotes.service.ClientService;
import com.tui.ordering.pilotes.service.PilotesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateOrderUseCaseImpl implements CreateOrderUseCase {

    private final SaveOrderRepository saveOrderRepository;
    private final PilotesService pilotesService;
    private final ClientService clientService;

    @Transactional
    @Override
    public Order execute(CreateOrderCommand command) {
        validateCommand(command);
        Order order = createOrderFromCommand(command);
        return saveOrderRepository.save(order);
    }

    private void validateCommand(CreateOrderCommand command) {
        pilotesService.validNumber(command.getPilotesNumber());
        clientService.retrieveClient(command.getUserIdentifier());
    }

    private Order createOrderFromCommand(CreateOrderCommand command) {
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
                .orderTotal(pilotesService.getPrice()+command.getPilotesNumber())
                .build();
    }
}