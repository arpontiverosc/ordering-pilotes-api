package com.tui.ordering.pilotes;

import com.tui.ordering.pilotes.model.Order;
import com.tui.ordering.pilotes.mother.OrderMother;
import com.tui.ordering.pilotes.port.in.UpdateOrderUseCase;
import com.tui.ordering.pilotes.port.in.model.UpdateOrderCommand;
import com.tui.ordering.pilotes.port.out.ConfigurationParamsRepository;
import com.tui.ordering.pilotes.port.out.SaveOrderRepository;
import com.tui.ordering.pilotes.service.ClientService;
import com.tui.ordering.pilotes.service.OrderService;
import com.tui.ordering.pilotes.mother.UpdateOrderCommandMother;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.ArgumentMatchers;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UpdateOrderUseCaseImplTest {

    private static final double PRICE = 1.33;
    private static final int TIME_UPDATABLE = 5;
    private UpdateOrderUseCase updateOrderUseCase;

    private SaveOrderRepository saveOrderRepository;
    private ConfigurationParamsRepository configurationParamsRepository;
    private ClientService clientService;
    private OrderService orderService;

    @BeforeAll
    public void setUp() {

        saveOrderRepository = mock(SaveOrderRepository.class);
        configurationParamsRepository = mock(ConfigurationParamsRepository.class);
        clientService = mock(ClientService.class);
        orderService = mock(OrderService.class);

        updateOrderUseCase = new UpdateOrderUseCaseImpl(saveOrderRepository, configurationParamsRepository, clientService, orderService);

    }


    @Test
    public void executeCommandTest(){

        UpdateOrderCommand updateOrderCommand = UpdateOrderCommandMother.create();

        when(configurationParamsRepository.getTimeUpdatable()).thenReturn(Optional.of(TIME_UPDATABLE));
        when(configurationParamsRepository.getPrice()).thenReturn(Optional.of(PRICE));
        when(configurationParamsRepository.findValues()).thenReturn(Arrays.asList(5,10,15));
        when(orderService.findById(updateOrderCommand.getOrderId())).thenReturn(OrderMother.createOrderFrom(updateOrderCommand, PRICE));

        updateOrderUseCase.execute(updateOrderCommand);

        verify(orderService).findById(updateOrderCommand.getOrderId());
        verify(clientService).retrieveClient(updateOrderCommand.getUserIdentifier());
        verify(saveOrderRepository).save(ArgumentMatchers.any(Order.class));


    }

}
