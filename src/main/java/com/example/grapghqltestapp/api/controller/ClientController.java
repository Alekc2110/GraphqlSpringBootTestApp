package com.example.grapghqltestapp.api.controller;

import com.example.grapghqltestapp.domain.model.Client;
import com.example.grapghqltestapp.domain.model.InvalidClient;
import com.example.grapghqltestapp.domain.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

/**
 * testController
 */
@Slf4j
@Controller
public class ClientController {

    @SchemaMapping(typeName = "Query", field = "client")
    public Client getClient(@Argument UUID id) {
        log.info("Retrieving client with id: {}", id);
        return Client.builder().id(id).firstName("Alex").middleNames(List.of("Junior", "Middle", "Senior")).lastName("Korsh").build();
    }


    @QueryMapping(value = "no_client")
    public InvalidClient exampleThrownRuntimeException(@Argument UUID id) {
        log.info("Retrieving invalid client id: {}", id);
        throw new ResourceNotFoundException("exception occurred when trying to get invalid client");
    }

}
