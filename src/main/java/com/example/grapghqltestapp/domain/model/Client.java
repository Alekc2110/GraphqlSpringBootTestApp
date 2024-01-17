package com.example.grapghqltestapp.domain.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;


@Builder
@Data
public class Client {

    UUID id;
    String firstName;
    List<String> middleNames;
    String lastName;
    Client client;


}
