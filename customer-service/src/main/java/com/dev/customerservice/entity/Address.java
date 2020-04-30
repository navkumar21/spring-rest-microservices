package com.dev.customerservice.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Address {


    @Id
    @GeneratedValue
    private Long id;
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String zipcode;
    private String country;
}
