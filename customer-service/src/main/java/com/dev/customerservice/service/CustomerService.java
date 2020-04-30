package com.dev.customerservice.service;

import com.dev.customerservice.entity.Customer;
import com.dev.customerservice.repository.CustomerRepository;
import com.dev.customerservice.repository.CustomerRepositoryJPQL;
import com.dev.customerservice.repository.CustomerRepositoryWithEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepositoryWithEntityManager repository;

    @Autowired
    CustomerRepositoryJPQL repositoryJPQL;

    @Autowired
    CustomerRepository customerRepository;

    public Customer getCustomer(Long id){
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(!optionalCustomer.isPresent()){
           throw new ResourceNotFoundException("Customer not found "+ id);
        }
        return optionalCustomer.get();

    }

    public List<Customer> getAllCustomer(){
        return (List<Customer>) customerRepository.findAll();
    }

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }
}
