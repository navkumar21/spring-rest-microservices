package com.dev.productservice.controller;

import com.dev.productservice.model.ProductResponse;
import com.dev.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @Value("${welcomeMessage}")
    private String welcomeMessage;

    @GetMapping("/welcome")
    public String welcome(){
        return welcomeMessage;
    }

    @GetMapping("/products/{productId}")
    public ProductResponse getProducts(@PathVariable String productId){
        return productService.getProductResponse(productId);
    }
}
