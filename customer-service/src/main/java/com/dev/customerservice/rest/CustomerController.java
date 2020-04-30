package com.dev.customerservice.rest;

import com.dev.customerservice.entity.Customer;
import com.dev.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to the programming ";
    }

    @GetMapping()
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomer();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return customerService.getCustomer(id);
    }

    @PostMapping()
    public Customer getCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }


}
