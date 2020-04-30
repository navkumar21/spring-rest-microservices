package com.dev.inventoryservice.service;

import com.dev.inventoryservice.entity.Inventory;
import com.dev.inventoryservice.model.InventoryResponse;
import com.dev.inventoryservice.model.StoreInventory;
import com.dev.inventoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository repository;

    public InventoryResponse getInventoryResponse(String productId){

        List<Inventory> inventories = repository.findByProductId(productId);

        InventoryResponse inventoryResponse = new InventoryResponse();
        inventoryResponse.setProductId(productId);

        List<StoreInventory>  storeInventories = inventories.stream()
                .map(StoreInventory::fromInventory)
                .collect(Collectors.toList());

        inventoryResponse.setStoreInventory(storeInventories);

        return inventoryResponse;
    }

}
