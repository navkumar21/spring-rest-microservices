package com.dev.productservice.client.model;

import lombok.Data;

import java.util.List;

@Data
public class InventoryResponse {

    private String productId;
    private List<StoreInventory> storeInventory;
}
