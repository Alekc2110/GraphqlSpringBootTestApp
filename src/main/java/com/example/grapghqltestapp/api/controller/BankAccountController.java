package com.example.grapghqltestapp.api.controller;

import com.example.grapghqltestapp.domain.model.BankAccount;
import com.example.grapghqltestapp.api.model.BankAccountInput;
import com.example.grapghqltestapp.domain.model.Client;
import com.example.grapghqltestapp.domain.model.Currency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Slf4j
@Controller
public class BankAccountController {

    @QueryMapping
    public BankAccount bankAccount(@Argument UUID id) {
        log.info("Retrieving bank account id: {}", id);
        Client clientA = Client.builder().id(id).firstName("Alex").middleNames(List.of("Junior", "Middle", "Senior")).lastName("Korsh").build();
        Client clientB = Client.builder().id(id).firstName("Inna").middleNames(List.of( "Senior")).lastName("Grech").build();
        clientA.setClient(clientB);
        clientB.setClient(clientA);
        return BankAccount.builder()
                .id(id)
                .client(clientA)
                .currency(Currency.USD)
                .build();
    }

    @MutationMapping(value = "addBankAccount")
    public BankAccount createBankAccount(@Argument BankAccountInput input){
        log.info("creating bank account for info {}", input);
        return BankAccount.builder()
                .id(UUID.randomUUID())
                .currency(Currency.CHF)
                .client(Client.builder().id(UUID.randomUUID()).firstName(input.firstName()).build())
                .build();
    }

}
