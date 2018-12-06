package com.deva.foody.controller;

import com.deva.foody.entity.OrderDetail;
import com.deva.foody.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/orders")
    public Iterable<OrderDetail> getOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/orders/{orderId}")
    public Optional<OrderDetail> getOrder(@PathVariable Long orderId) {
        return orderRepository.findByOrderId(orderId);
    }

    @PostMapping("/orders")
    public OrderDetail createOrders(@Valid @RequestBody OrderDetail orderDetail) {
        return orderRepository.save(orderDetail);
    }
}
