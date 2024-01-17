package com.example.grapghqltestapp.persistence.repository;


import com.example.grapghqltestapp.persistence.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

 public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerByEmail(String email);
}
