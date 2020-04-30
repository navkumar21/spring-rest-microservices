package com.dev.inventoryservice.model;

import lombok.Data;

import java.util.List;

@Data
public class InventoryResponse {

    private String productId;
    private List<StoreInventory> storeInventory;

}
