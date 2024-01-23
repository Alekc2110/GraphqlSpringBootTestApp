package com.example.grapghqltestapp.persistence.repository;


import com.example.grapghqltestapp.persistence.entity.Customer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerByEmail(String email);

    @EntityGraph(value = "customerEntityGraph")
    List<Customer> findAll();
}
