package com.tui.ordering.pilotes;

import com.tui.ordering.pilotes.model.Order;
import com.tui.ordering.pilotes.mother.CreateOrderCommandMother;
import com.tui.ordering.pilotes.mother.OrderMother;
import com.tui.ordering.pilotes.port.in.CreateOrderUseCase;
import com.tui.ordering.pilotes.port.in.model.CreateOrderCommand;
import com.tui.ordering.pilotes.port.out.ConfigurationParamsRepository;
import com.tui.ordering.pilotes.port.out.SaveOrderRepository;
import com.tui.ordering.pilotes.service.ClientService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.ArgumentMatchers;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CreateOrderUseCaseImplTest {

    private static final double PRICE = 1.33;

    private CreateOrderUseCase createOrderUseCase;

    private SaveOrderRepository saveOrderRepository;

    private ConfigurationParamsRepository configurationParamsRepository;

    private ClientService clientService;

    @BeforeAll
    public void setUp() {

        saveOrderRepository = mock(SaveOrderRepository.class);
        clientService = mock(ClientService.class);
        configurationParamsRepository = mock(ConfigurationParamsRepository.class);

        createOrderUseCase = new CreateOrderUseCaseImpl(saveOrderRepository, clientService, configurationParamsRepository);

    }


    @Test
    public void executeCommandTest() {

        CreateOrderCommand createOrderCommand = CreateOrderCommandMother.create();
        Order orderCreated = OrderMother.createdAtOrderFrom(createOrderCommand, PRICE, OffsetDateTime.now());

        when(configurationParamsRepository.getPrice()).thenReturn(Optional.of(PRICE));
        when(configurationParamsRepository.findValues()).thenReturn(Arrays.asList(5,10,15));
        when(saveOrderRepository.save(ArgumentMatchers.any(Order.class))).thenReturn(orderCreated);

        Order orderSaved = createOrderUseCase.execute(createOrderCommand);


        verify(clientService).retrieveClient(createOrderCommand.getUserIdentifier());

        assertNotNull(orderSaved.getOrderId());
        assertNotNull(orderSaved.getCreatedAt());
        assertNotNull(orderSaved.getEmail());
        assertNotNull(orderSaved.getDeliveryAddress());
        assertEquals(orderSaved.getOrderTotal(), PRICE * createOrderCommand.getPilotesNumber());

    }


}
