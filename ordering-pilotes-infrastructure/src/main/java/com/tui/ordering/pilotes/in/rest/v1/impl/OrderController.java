package com.tui.ordering.pilotes.in.rest.v1.impl;

import com.tui.ordering.pilotes.in.rest.v1.OrderPilotesApi;
import com.tui.ordering.pilotes.in.rest.v1.mapper.command.CreateOrderCommandMapper;
import com.tui.ordering.pilotes.in.rest.v1.mapper.response.CreateOrderResponseMapper;
import com.tui.ordering.pilotes.in.rest.v1.mapper.response.DetailOrderResponseMapper;
import com.tui.ordering.pilotes.in.rest.v1.model.request.CreateOrderRequest;
import com.tui.ordering.pilotes.in.rest.v1.model.response.CreateOrderResponse;
import com.tui.ordering.pilotes.in.rest.v1.model.response.DetailOrderResponse;
import com.tui.ordering.pilotes.model.Order;
import com.tui.ordering.pilotes.port.in.CreateOrderUseCase;
import com.tui.ordering.pilotes.port.in.SearchOrdersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController implements OrderPilotesApi {

    private final CreateOrderUseCase createOrderUseCase;
    private final SearchOrdersUseCase searchOrdersUseCase;

    @Override
    public CreateOrderResponse createOrderV1(CreateOrderRequest request) {
        return CreateOrderResponseMapper.from(createOrderUseCase.execute(CreateOrderCommandMapper.from(request)));
    }

    @Override
    public List<DetailOrderResponse> searchOrdersV1(String search) {
        List<Order> orders = searchOrdersUseCase.execute(search);
        return orders.stream().map(DetailOrderResponseMapper::from).toList();
    }
}
