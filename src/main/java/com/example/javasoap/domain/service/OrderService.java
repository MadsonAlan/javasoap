package com.example.javasoap.domain.service;

import com.example.order.Order;
import com.example.javasoap.domain.repository.OrderRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepositoryInterface repository;


    public Order findById(Long id) {
        return repository.findById(id);
    }
}
