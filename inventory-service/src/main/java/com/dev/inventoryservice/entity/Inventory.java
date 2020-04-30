package com.dev.inventoryservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Inventory {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String productId;
    private String storeId;
    private int quantity;
    private double unitPrice;
}
