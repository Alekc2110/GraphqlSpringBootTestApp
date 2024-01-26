package com.example.grapghqltestapp.domain.model;

import com.example.grapghqltestapp.persistence.entity.Customer;
import java.time.LocalDate;
import java.time.LocalTime;

public record CustomerAccountSuccess(Customer customer, LocalTime createdAt) {
}
