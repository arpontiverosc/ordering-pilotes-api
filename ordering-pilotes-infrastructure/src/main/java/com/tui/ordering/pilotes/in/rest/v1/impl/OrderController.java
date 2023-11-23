package com.tui.ordering.pilotes.in.rest.v1.impl;

import com.tui.ordering.pilotes.in.rest.v1.OrderPilotesApi;
import com.tui.ordering.pilotes.in.rest.v1.mapper.command.CreateOrderCommandMapper;
import com.tui.ordering.pilotes.in.rest.v1.mapper.response.CreateOrderResponseMapper;
import com.tui.ordering.pilotes.in.rest.v1.model.request.CreateOrderRequest;
import com.tui.ordering.pilotes.in.rest.v1.model.response.CreateOrderResponse;
import com.tui.ordering.pilotes.port.in.CreateOrderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class xOrderController implements OrderPilotesApi {

    private final CreateOrderUseCase createOrderUseCase;

    @Override
    public CreateOrderResponse createCustomerV1(CreateOrderRequest request) {
        return CreateOrderResponseMapper.from(createOrderUseCase.execute(CreateOrderCommandMapper.from(request)));
    }
}
