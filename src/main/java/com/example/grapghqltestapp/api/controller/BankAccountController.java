package com.example.grapghqltestapp.api.controller;

import com.example.grapghqltestapp.api.payload.BankAccountInput;
import com.example.grapghqltestapp.domain.exceptions.ResourceNotFoundException;
import com.example.grapghqltestapp.domain.model.BankAccount;
import com.example.grapghqltestapp.domain.model.CustomerAccountSuccess;
import com.example.grapghqltestapp.persistence.entity.Customer;
import com.example.grapghqltestapp.persistence.repository.CustomerRepository;
import com.example.grapghqltestapp.persistence.repository.RemoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.LocalTime;

@Slf4j
@Controller
public class BankAccountController {

    private final CustomerRepository repository;
    private final RemoteRepository remoteRepository;

    public BankAccountController(CustomerRepository repository, RemoteRepository remoteRepository) {
        this.repository = repository;
        this.remoteRepository = remoteRepository;
    }

    @QueryMapping
    public BankAccount bankAccount(@Argument Long clientId) {
        log.info("Retrieving bank account customer id: {}", clientId);
        Customer customer = repository.findById(clientId).orElseThrow(
                () -> new ResourceNotFoundException(String.format("client with id: %d, not found", clientId)));
        return remoteRepository.retrieveBankAccount(customer.getId());
    }

    @MutationMapping(value = "addBankAccount")
    public CustomerAccountSuccess createBankAccount(@Argument BankAccountInput input) {
        log.info("creating bank account for info {}", input);
        Customer customer = repository.findById(input.customerId()).orElseThrow();
        CustomerAccountSuccess customerAccountSuccess = new CustomerAccountSuccess(
                customer,
                LocalTime.now()
        );
        log.info("created CustomerAccountSuccess: {}", customerAccountSuccess);
        return customerAccountSuccess;
    }

    @SchemaMapping(typeName = "CustomerAccountSuccess")
    public BankAccount bankAccount(CustomerAccountSuccess customerAccountSuccess) {
        return remoteRepository.createBankAccount(customerAccountSuccess.customer().getId());
    }
}
