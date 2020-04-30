package com.dev.inventoryservice.controller;

import com.dev.inventoryservice.model.InventoryResponse;
import com.dev.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @Value("${inventory.greeting}")
    private String greetings;


    @GetMapping("/inventory/greeting")
    public String getInventoryGreetings(@PathVariable String productId){
        return greetings;
    }

    @GetMapping("/inventory/{productId}")
    public InventoryResponse getInventory(@PathVariable String productId){
        return inventoryService.getInventoryResponse(productId);
    }
}
