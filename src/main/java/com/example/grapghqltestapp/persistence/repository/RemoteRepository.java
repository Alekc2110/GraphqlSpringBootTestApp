package com.example.grapghqltestapp.persistence.repository;

import com.example.grapghqltestapp.domain.model.BankAccount;
import com.example.grapghqltestapp.domain.model.Currency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Repository
public class RemoteRepository {
    private final Map<Long, BankAccount> storage = new HashMap<>();

    public BankAccount retrieveBankAccount(Long clientId){
       log.info("retrieve BankAccount from remote repo for client id {}", clientId);
       return storage.computeIfAbsent(clientId, id -> BankAccount.builder()
                .id(UUID.randomUUID())
                .currency(Currency.CHF)
                .customerId(id)
                .build());
    }
    public BankAccount createBankAccount(Long clientId){
        log.info("create BankAccount in remote repo for client id {}", clientId);
        BankAccount newAccount = BankAccount.builder()
                .id(UUID.randomUUID())
                .currency(Currency.USD)
                .customerId(clientId)
                .build();
       storage.putIfAbsent(clientId, newAccount);
       return storage.get(clientId);
    }
}
