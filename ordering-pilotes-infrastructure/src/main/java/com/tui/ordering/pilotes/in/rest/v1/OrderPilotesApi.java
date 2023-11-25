package com.tui.ordering.pilotes.in.rest.v1;

import com.tui.ordering.pilotes.in.rest.v1.model.request.CreateOrderRequest;
import com.tui.ordering.pilotes.in.rest.v1.model.request.SearchOrderRequest;
import com.tui.ordering.pilotes.in.rest.v1.model.request.UpdateOrderRequest;
import com.tui.ordering.pilotes.in.rest.v1.model.response.CreateOrderResponse;
import com.tui.ordering.pilotes.in.rest.v1.model.response.DetailOrderResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/v1/orders")
public interface OrderPilotesApi {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    CreateOrderResponse createOrderV1(@Valid @RequestBody CreateOrderRequest request);


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    List<DetailOrderResponse> searchOrdersV1(SearchOrderRequest searchOrderRequest);


    @PutMapping(path = "/{orderId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateOrderV1(
            @PathVariable("orderId") String orderId,
            @Valid @RequestBody UpdateOrderRequest request);


}
