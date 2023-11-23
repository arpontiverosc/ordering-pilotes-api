package com.tui.ordering.pilotes;

import com.tui.ordering.pilotes.model.Order;
import com.tui.ordering.pilotes.port.in.CreateOrderUseCase;
import com.tui.ordering.pilotes.port.in.model.CreateOrderCommand;
import com.tui.ordering.pilotes.port.in.model.OrderAddress;
import com.tui.ordering.pilotes.port.out.FindPilotePriceRepository;
import com.tui.ordering.pilotes.port.out.SaveOrderRepository;
import com.tui.ordering.pilotes.service.FindPilotePriceService;
import com.tui.ordering.pilotes.service.ValidPilotesValuesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateOrderUseCaseImpl implements CreateOrderUseCase {

    private final SaveOrderRepository saveOrderRepository;
    private final FindPilotePriceService findPilotePriceService;
    private final ValidPilotesValuesService validPilotesValuesService;

    @Transactional
    @Override
    public Order execute(CreateOrderCommand command) {
        validateCommand(command);
        Order order = createOrderFromCommand(command);
        return saveOrderRepository.save(order);
    }

    private void validateCommand(CreateOrderCommand command) {
        //choosing between 5, 10 or 15 pilotes
        validPilotesValuesService.verify(command.getPilotes());
    }

    private Order createOrderFromCommand(CreateOrderCommand command) {
        return Order.Builder.builder()
                .deliveryAddress(OrderAddress.Builder.builder().postcode(command.getDeliveryAddress().getPostcode())
                        .city(command.getDeliveryAddress().getCity())
                        .street(command.getDeliveryAddress().getStreet())
                        .country(command.getDeliveryAddress().getCountry())
                        .postcode(command.getDeliveryAddress().getPostcode())
                        .build()
                )
                .userIdentifier(UUID.randomUUID().toString())
                .pilotes(command.getPilotes())
                .orderTotal(findPilotePriceService.getPrice()+command.getPilotes())
                .build();

    }
}