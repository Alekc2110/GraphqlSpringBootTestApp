package com.example.grapghqltestapp.persistence.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NamedEntityGraph(
        name = "customerEntityGraph",
        attributeNodes = @NamedAttributeNode(value = "orders", subgraph = "subgraph.orders"),
        subgraphs = {
                @NamedSubgraph(
                        name = "subgraph.orders",
                        attributeNodes = @NamedAttributeNode(value = "orderLines", subgraph = "subgraph.orderline.product")
                ),
                @NamedSubgraph(
                        name = "subgraph.orderline.product",
                        attributeNodes = @NamedAttributeNode(value = "product")
                ),
                @NamedSubgraph(
                        name = "subgraph.orders",
                        attributeNodes = @NamedAttributeNode("salesperson")
                )
        })
@Entity(name = "customer")
@Table(name = "CUSTOMERS")
public class Customer {
    @Id
    @Column(name = "CUSTOMER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phoneNumber;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "ZIPCODE")
    private String zipCode;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;
}
