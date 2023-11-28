package com.tui.ordering.pilotes;

import com.tui.ordering.pilotes.exception.OrderBeingCookingException;
import com.tui.ordering.pilotes.exception.PiloteNumberException;
import com.tui.ordering.pilotes.exception.PriceNotFoundException;
import com.tui.ordering.pilotes.model.Address;
import com.tui.ordering.pilotes.model.Customer;
import com.tui.ordering.pilotes.model.Order;
import com.tui.ordering.pilotes.port.in.UpdateOrderUseCase;
import com.tui.ordering.pilotes.port.in.model.UpdateOrderCommand;
import com.tui.ordering.pilotes.port.out.ConfigurationParamsRepository;
import com.tui.ordering.pilotes.port.out.SaveOrderRepository;
import com.tui.ordering.pilotes.service.ClientService;
import com.tui.ordering.pilotes.service.OrderService;
import com.tui.ordering.pilotes.exception.TimeUpdatableNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateOrderUseCaseImpl implements UpdateOrderUseCase {

    private final SaveOrderRepository saveOrderRepository;
    private final ConfigurationParamsRepository configurationParamsRepository;
    private final ClientService clientService;
    private final OrderService orderService;

    @Transactional
    @Override
    public void execute(UpdateOrderCommand command) {
        validateCommand(command);
        Order order = createOrderFromCommand(command);
        validateTimeUpdatable(order.getOrderId());
        validatePilotesNumber(order);
        saveOrderRepository.save(order);
    }

    private void validatePilotesNumber(Order order){
        if (!order.isRightPilotesNumber(configurationParamsRepository.findValues())) {
            throw new PiloteNumberException();
        }
    }

    private void validateTimeUpdatable(String orderId){
        Order order = orderService.findById(orderId);
        if(order.isAfter(configurationParamsRepository.getTimeUpdatable()
                .orElseThrow(TimeUpdatableNotFoundException::new))){
            throw new OrderBeingCookingException();
        }
    }

    private void validateCommand(UpdateOrderCommand command) {
        clientService.retrieveClient(command.getUserIdentifier());
    }

    private Order createOrderFromCommand(UpdateOrderCommand command) {
        return Order.Builder.builder().orderId(command.getOrderId())
                .deliveryAddress(Address.Builder.builder()
                        .postcode(command.getDeliveryAddress().getPostcode())
                        .city(command.getDeliveryAddress().getCity())
                        .street(command.getDeliveryAddress().getStreet())
                        .country(command.getDeliveryAddress().getCountry())
                        .postcode(command.getDeliveryAddress().getPostcode())
                        .build())
                .customer(Customer.Builder.builder()
                        .customerId(command.getUserIdentifier()).build())
                .pilotes(command.getPilotesNumber())
                .orderTotal(configurationParamsRepository.getPrice().orElseThrow(PriceNotFoundException::new)*command.getPilotesNumber())
                .email(command.getEmail())
                .build();
    }
}
