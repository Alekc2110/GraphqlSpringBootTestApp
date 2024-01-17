package com.example.grapghqltestapp.persistence.repository;

import com.example.grapghqltestapp.persistence.entity.SalesPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalespersonRepository extends JpaRepository<SalesPerson, Long> {
    SalesPerson findSalespersonByEmail(String email);
}