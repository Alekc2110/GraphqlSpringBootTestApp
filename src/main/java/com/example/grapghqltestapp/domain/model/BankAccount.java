package com.example.grapghqltestapp.domain.model;

import lombok.*;

import java.util.UUID;

@ToString
@Getter
@Setter
@Builder
public class BankAccount {
    UUID id;
    Long customerId;
    Currency currency;
}
