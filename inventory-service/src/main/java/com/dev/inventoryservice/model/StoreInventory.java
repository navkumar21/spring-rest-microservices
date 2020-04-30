package com.dev.inventoryservice.model;

import com.dev.inventoryservice.entity.Inventory;
import lombok.Data;

@Data
public class StoreInventory {

    private String storeId;
    private int quantity;
    private double unitPrice;

    public static StoreInventory fromInventory(Inventory inventory){
        StoreInventory storeInventory = new StoreInventory();
        storeInventory.setStoreId(inventory.getStoreId());
        storeInventory.setUnitPrice(inventory.getUnitPrice());
        storeInventory.setQuantity(inventory.getQuantity());
        return storeInventory;
    }

}
