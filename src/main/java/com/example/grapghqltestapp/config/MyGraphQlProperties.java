package com.example.grapghqltestapp.config;

import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;

public class MyGraphQlProperties extends GraphQlProperties {
    private final static String MY_PATH = "/mygraphql";

    public MyGraphQlProperties() {
       setPath(MY_PATH);
    }
}
