package com.example.grapghqltestapp.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name="PRODUCTS")
public class Product {

    @Id
    @Column(name="PRODUCT_ID")
    private String id;

    @Column(name="NAME")
    private String name;

    @Column(name="SIZE")
    private int size;

    @Column(name="VARIETY")
    private String variety;

    @Column(name="PRICE")
    private BigDecimal price;

    @Column(name="STATUS")
    private String status;


}