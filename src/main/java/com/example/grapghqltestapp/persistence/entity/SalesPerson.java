package com.example.grapghqltestapp.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.*;

@Getter
@Setter
@Entity
@Table(name="SALESPEOPLE")
public class SalesPerson {
    @Id
    @Column(name="SALESPERSON_ID")
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="EMAIL")
    private String email;

    @Column(name="PHONE")
    private String phoneNumber;

    @Column(name="ADDRESS")
    private String address;

    @Column(name="CITY")
    private String city;

    @Column(name="STATE")
    private String state;

    @Column(name="ZIPCODE")
    private String zipCode;

}