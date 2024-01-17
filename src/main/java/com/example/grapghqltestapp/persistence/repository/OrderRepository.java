package com.example.grapghqltestapp.persistence.repository;

import com.example.grapghqltestapp.persistence.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}