package com.example.grapghqltestapp.persistence.repository;

import com.example.grapghqltestapp.persistence.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
}

