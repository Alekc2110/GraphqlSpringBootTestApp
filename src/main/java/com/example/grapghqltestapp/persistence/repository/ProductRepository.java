package com.example.grapghqltestapp.persistence.repository;

import com.example.grapghqltestapp.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
