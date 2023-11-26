package com.tui.ordering.pilotes;

import com.tui.ordering.pilotes.model.Address;
import com.tui.ordering.pilotes.model.Customer;
import com.tui.ordering.pilotes.model.Order;
import com.tui.ordering.pilotes.port.in.UpdateOrderUseCase;
import com.tui.ordering.pilotes.port.in.model.UpdateOrderCommand;
import com.tui.ordering.pilotes.port.out.ConfigurationParamsRepository;
import com.tui.ordering.pilotes.port.out.SaveOrderRepository;
import com.tui.ordering.pilotes.service.ClientService;
import com.tui.ordering.pilotes.service.OrderService;
import com.tui.ordering.pilotes.service.PilotesService;
import com.tui.ordering.pilotes.exception.TimeUpdatableNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateOrderUseCaseImpl implements UpdateOrderUseCase {

    private final SaveOrderRepository saveOrderRepository;
    private final ConfigurationParamsRepository configurationParamsRepository;
    private final PilotesService pilotesService;
    private final ClientService clientService;
    private final OrderService orderService;

    @Transactional
    @Override
    public void execute(UpdateOrderCommand command) {
        validateCommand(command);
        Order order = createOrderFromCommand(command);
        saveOrderRepository.save(order);
    }

    private void validateCommand(UpdateOrderCommand command) {
        orderService.findById(command.getOrderId());
        pilotesService.validNumber(command.getPilotesNumber());
        clientService.retrieveClient(command.getUserIdentifier());
        orderService.isBefore(configurationParamsRepository.getTimeUpdatable()
                                    .orElseThrow(TimeUpdatableNotFoundException::new), command.getOrderId());
    }

    private Order createOrderFromCommand(UpdateOrderCommand command) {
        return Order.Builder.builder().orderId(command.getOrderId()).deliveryAddress(Address.Builder.builder().postcode(command.getDeliveryAddress().getPostcode()).city(command.getDeliveryAddress().getCity()).street(command.getDeliveryAddress().getStreet()).country(command.getDeliveryAddress().getCountry()).postcode(command.getDeliveryAddress().getPostcode()).build()).customer(Customer.Builder.builder().customerId(command.getUserIdentifier()).build()).pilotes(command.getPilotesNumber()).orderTotal(pilotesService.getPrice() + command.getPilotesNumber()).build();
    }
}
