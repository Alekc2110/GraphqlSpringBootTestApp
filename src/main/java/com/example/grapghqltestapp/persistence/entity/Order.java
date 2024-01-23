package com.example.grapghqltestapp.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="ORDERS")
public class Order {
    @Id
    @Column(name="ORDER_ID")
    private String id;

    @ManyToOne
    @JoinColumn(name="CUSTOMER_ID", nullable = false, updatable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="SALESPERSON_ID", nullable = false, updatable = false)
    private SalesPerson salesperson;

    @OneToMany(mappedBy = "order")
    private Set<OrderLine> orderLines;




}