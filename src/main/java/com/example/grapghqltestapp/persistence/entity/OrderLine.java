package com.example.grapghqltestapp.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="ORDER_LINES")
public class OrderLine {
    @Id
    @Column(name="ORDER_LINE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="ORDER_ID", nullable = false, updatable = false)
    private Order order;

    @OneToOne
    @JoinColumn(name="PRODUCT_ID", nullable = false, updatable = false)
    private Product product;

    @Column(name="QUANTITY")
    private int quantity;

}

