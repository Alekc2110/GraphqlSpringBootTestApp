package com.example.grapghqltestapp.api.controller;

import com.example.grapghqltestapp.persistence.entity.Order;
import com.example.grapghqltestapp.persistence.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class OrderController {
    private final OrderRepository orderRepository;


    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @QueryMapping
    public Iterable<Order> orders(){
        log.info("Retrieving all orders");
        return this.orderRepository.findAll();
    }

    @QueryMapping
    public Order orderById(@Argument String id){
        log.info("Retrieving order with id: {}", id);
        return this.orderRepository.findById(id).orElseThrow();
    }
}
