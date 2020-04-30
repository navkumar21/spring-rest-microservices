package com.dev.customerservice.repository;

import com.dev.customerservice.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class CustomerRepositoryWithEntityManager {

    //EntityManager is interface to the persistence context, all the entities are persisted through persistence context.
    //Persistence context will keep track of all entities which are changed through out the transaction.
    @Autowired
    EntityManager entityManager;

    public Customer findById(Long id){
        return entityManager.find(Customer.class, id);
    }

    //insert or update
    public Customer save(Customer customer){
        if(customer.getId() == null){
            entityManager.persist(customer.getIdentity());
            entityManager.persist(customer);
        } else {
            entityManager.merge(customer.getIdentity());
            entityManager.merge(customer);
        }
        return customer;
    }

    public void deleteById(Long id){
        Customer customer = findById(id);
        entityManager.remove(customer);
    }

    public void trackChangesByEntityManager(Customer customer){
        entityManager.persist(customer);
        //automatically persist with out calling persist method
        // if we are in transaction, entity manager will  keep track of all changes.
        customer.setFirstName("trackChangesByEntityManager");
    }

    public void doNotTrackChangesByEntityManager(Customer customer){
        entityManager.persist(customer);
        customer.setFirstName("doNotTrackChangesByEntityManager");
        entityManager.flush(); //will insert the latest data
        //if there are more than one object there and we want flush all the objects we can use clear method
        //entityManager.clear(customer);

        //after detach method entity changes are no longer tracked by entity manager.
        entityManager.detach(customer);
        customer.setFirstName("trackChangesByEntityManager");
        entityManager.flush();
    }

    public void refreshChangesByEntityManager(Customer customer){
        entityManager.persist(customer);
        customer.setFirstName("trackChangesByEntityManager");
        entityManager.flush();

        customer.setFirstName("refresh updates should lost");
        entityManager.refresh(customer);

        entityManager.flush();
    }
}
