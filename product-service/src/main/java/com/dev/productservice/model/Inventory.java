package com.dev.productservice.model;

import com.dev.productservice.client.model.InventoryResponse;
import com.dev.productservice.client.model.StoreInventory;
import lombok.Data;

@Data
public class Inventory {
    private String storeId;
    private int quantity;
    private double unitPrice;

    public static Inventory fromStoreInventory(StoreInventory storeInventory) {
        Inventory inventory = new Inventory();
        inventory.setStoreId(storeInventory.getStoreId());
        inventory.setQuantity(storeInventory.getQuantity());
        inventory.setUnitPrice(storeInventory.getUnitPrice());

        return inventory;
    }
}
