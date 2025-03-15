package com.example.javasoap.domain.repository;

import com.example.order.Order;

public interface OrderRepositoryInterface {
    Order findById(Long id);
}
