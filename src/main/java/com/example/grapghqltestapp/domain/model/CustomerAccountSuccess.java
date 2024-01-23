package com.example.grapghqltestapp.domain.model;

import com.example.grapghqltestapp.persistence.entity.Customer;
import java.time.LocalDate;

public record CustomerAccountSuccess(Customer customer, LocalDate createdAt) {
}
