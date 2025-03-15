package com.example.javasoap.infrastructure.soap.producer;

import com.example.order.Order;
import com.example.order.OrderResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderSoapMapper {
    OrderResponse toResponse(Order order);
}
