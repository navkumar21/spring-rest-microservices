package com.dev.productservice.client;

import com.dev.productservice.client.model.InventoryResponse;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Ribbon for load balancing
//Eureka for client discovery

//@FeignClient (name = "inventory-service", url = "localhost:8500")
@FeignClient (name = "inventory-service")
@RibbonClient(name = "inventory-service")
public interface InventoryApiClient {

    @GetMapping("/inventory/{productId}")
    InventoryResponse getInventory(@PathVariable("productId") String productId);

}
