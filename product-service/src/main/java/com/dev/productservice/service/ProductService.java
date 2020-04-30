package com.dev.productservice.service;

import com.dev.productservice.client.InventoryApiClient;
import com.dev.productservice.client.model.InventoryResponse;
import com.dev.productservice.model.Inventory;
import com.dev.productservice.model.ProductResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    InventoryApiClient apiClient;

    public ProductResponse getProductResponse(String productId){

        InventoryResponse inventoryResponse = apiClient.getInventory(productId);

        /*
        sleuth will trace the request
        INFO [product-service,9dfa45c297f17a33,9dfa45c297f17a33,false]
        pattern -> [service-name, traceId, spanId, Export]
         */
        logger.info("Inventory Service API call, productId : {} , response : {} "+ productId, inventoryResponse);

        ProductResponse response = new ProductResponse();
        List<Inventory> inventoryList = inventoryResponse.getStoreInventory()
                .stream()
                .map(Inventory::fromStoreInventory)
                .collect(Collectors.toList());

        response.setProductId(productId);
        response.setInventory(inventoryList);
        response.setProductReviews(new ArrayList<>());

        return response;
    }
}
