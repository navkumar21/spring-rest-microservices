package com.dev.customerservice.repository;

import com.dev.customerservice.entity.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

// If we use junit4 -> @RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
class CustomerRepositoryWithEntityManagerTest {

    @Autowired
    CustomerRepositoryWithEntityManager repository;

    @Test
    void findById() {
        Customer customer = repository.findById(1000L);
        assertEquals("raj", customer.getFirstName());
    }

    @Test
    @DirtiesContext
    void save() {
        Customer customer = repository.findById(1000L);
        customer.setFirstName("raj kumar");
        Customer updatedCustomer = repository.save(customer);
        assertEquals("raj kumar", updatedCustomer.getFirstName());
    }

    @Test
    @DirtiesContext
        // resets the data back
    void deleteById() {
        repository.deleteById(1000L);
        assertNull(repository.findById(1000L));
    }

    @Test
    @DirtiesContext
    void trackChangesByEntityManager() {
        Customer customer = new Customer();
        customer.setFirstName("first name");
        repository.trackChangesByEntityManager(customer);

        Customer updatedCustomer = repository.findById(1L);
        assertEquals("trackChangesByEntityManager", updatedCustomer.getFirstName());
    }

    @Test
    @DirtiesContext
    void doNotTrackChangesByEntityManager() {
        Customer customer = new Customer();
        customer.setFirstName("first name");
        repository.doNotTrackChangesByEntityManager(customer);

        Customer updatedCustomer = repository.findById(1L);
        assertEquals("doNotTrackChangesByEntityManager", updatedCustomer.getFirstName());
    }

    @Test
    @DirtiesContext
    void refreshChangesByEntityManager() {
        Customer customer = new Customer();
        customer.setFirstName("first name");
        repository.refreshChangesByEntityManager(customer);

        Customer updatedCustomer = repository.findById(1L);
        assertEquals("trackChangesByEntityManager", updatedCustomer.getFirstName());
    }
}