package com.example.grapghqltestapp.domain.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class InvalidClient {
    UUID id;
}
