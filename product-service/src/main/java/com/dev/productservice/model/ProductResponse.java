package com.dev.productservice.model;

import lombok.Data;

import java.util.List;

@Data
public class ProductResponse {
    private String productId;
    private List<Inventory> inventory;
    private List<ProductReview> productReviews;
}
