package com.dev.productservice.client.model;

import lombok.Data;

@Data
public class StoreInventory {

    private String storeId;
    private int quantity;
    private double unitPrice;
}
