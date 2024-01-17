package com.example.grapghqltestapp.api.controller;

import com.example.grapghqltestapp.persistence.entity.Product;
import com.example.grapghqltestapp.persistence.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryMapping
    public Iterable<Product> products() {
        log.info("Retrieving all products");
        return this.productRepository.findAll();
    }

    @QueryMapping
    public Product productById(@Argument String id) {
        log.info("Retrieving product with id: {}", id);
        return this.productRepository.findById(id).orElseThrow();
    }
}
