package com.example.javasoap.infrastructure.soap.producer;

import com.example.order.Order;
import com.example.javasoap.domain.service.OrderService;
import com.example.order.OrderRequest;
import com.example.order.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class OrderEndpoint {

    private final OrderService orderService;
    private final OrderSoapMapper mapper;

    @PayloadRoot(namespace = "http://example.com/order", localPart = "OrderRequest")
    @ResponsePayload
    public OrderResponse getOrder(@RequestPayload OrderRequest request) {
        Order order = orderService.findById(request.getId());
        return mapper.toResponse(order);
    }
}
