package com.example.grapghqltestapp.api.controller;

import com.example.grapghqltestapp.persistence.entity.SalesPerson;
import com.example.grapghqltestapp.persistence.repository.SalespersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class SalesPersonController {
    private final SalespersonRepository salespersonRepository;

    public SalesPersonController(SalespersonRepository salespersonRepository) {
        this.salespersonRepository = salespersonRepository;
    }

    @QueryMapping
    public Iterable<SalesPerson> salespeople(){
        return this.salespersonRepository.findAll();
    }

    @QueryMapping
    public SalesPerson salespersonById(@Argument Long id){
        log.info("Retrieving salesPerson by id: {}", id);
        return this.salespersonRepository.findById(id).orElseThrow();
    }

    @QueryMapping
    public SalesPerson salespersonByEmail(@Argument String email){
        log.info("Retrieving salesPerson by email: {}", email);
        return this.salespersonRepository.findSalespersonByEmail(email);
    }
}
