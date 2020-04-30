package com.dev.customerservice.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Membership {

    @Id
    @GeneratedValue
    private int id;
    private int membershipTypeId;
    private int customer_id;

}
