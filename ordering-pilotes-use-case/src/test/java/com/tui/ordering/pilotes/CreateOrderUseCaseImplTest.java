package com.tui.ordering.pilotes;

import com.tui.ordering.pilotes.model.Order;
import com.tui.ordering.pilotes.mother.CreateOrderCommandMother;
import com.tui.ordering.pilotes.mother.OrderMother;
import com.tui.ordering.pilotes.port.in.CreateOrderUseCase;
import com.tui.ordering.pilotes.port.in.model.CreateOrderCommand;
import com.tui.ordering.pilotes.port.out.SaveOrderRepository;
import com.tui.ordering.pilotes.service.ClientService;
import com.tui.ordering.pilotes.service.PilotesService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.ArgumentMatchers;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CreateOrderUseCaseImplTest {

    private static final double PRICE = 1.33;

    private CreateOrderUseCase createOrderUseCase;

    private SaveOrderRepository saveOrderRepository;
    private PilotesService pilotesService;
    private ClientService clientService;

    @BeforeAll
    public void setUp() {

        saveOrderRepository = mock(SaveOrderRepository.class);
        pilotesService = mock(PilotesService.class);
        clientService = mock(ClientService.class);

        createOrderUseCase = new CreateOrderUseCaseImpl(saveOrderRepository, pilotesService, clientService);

    }


    @Test
    public void executeCommandTest() {

        CreateOrderCommand createOrderCommand = CreateOrderCommandMother.create();
        Order order = OrderMother.createOrderFrom(createOrderCommand, PRICE);
        Order orderCreated = OrderMother.createdAtOrderFrom(createOrderCommand, PRICE, OffsetDateTime.now());

        when(pilotesService.getPrice()).thenReturn(PRICE);
        when(saveOrderRepository.save(ArgumentMatchers.any(Order.class))).thenReturn(orderCreated);

        Order orderSaved = createOrderUseCase.execute(createOrderCommand);

        verify(pilotesService).validNumber(createOrderCommand.getPilotesNumber());
        verify(clientService).retrieveClient(createOrderCommand.getUserIdentifier());

        assertNotNull(orderSaved.getOrderId());
        assertNotNull(orderSaved.getCreatedAt());
        assertNotNull(orderSaved.getEmail());
        assertNotNull(orderSaved.getDeliveryAddress());
        assertEquals(orderSaved.getOrderTotal(), PRICE * createOrderCommand.getPilotesNumber());

    }


}
