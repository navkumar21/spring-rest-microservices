package com.dev.customerservice.repository;

import com.dev.customerservice.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

//JPQL we query from entities, JPQL queries will be converted to SQL queries by Hibernate implementation.
// SQL - select * from customer
//JPQL - select c from customer c


@Transactional
@Repository
public class CustomerRepositoryJPQL {

    @Autowired
    EntityManager entityManager;

    public List findAllCustomersWithOutType(){
        Query query = entityManager.createQuery("select c from customer c");
        List results = query.getResultList();
        return results;
    }

    public List<Customer> findAllCustomersWithType(){
        TypedQuery typedQuery = entityManager.createQuery("select c from customer c", Customer.class);
        List<Customer> results = typedQuery.getResultList();
        return results;
    }

    //Named query
    public List<Customer> findAllCustomersByNamedQuery(){
        TypedQuery typedQuery = entityManager.createNamedQuery(Customer.SELECT_ALL_CUSTOMERS, Customer.class);
        return typedQuery.getResultList();
    }

    // some scenarios we need to use native query,
    // example if JPA doesn't support some database feature,
    // in-case if we want to bulk update, JPA doesn't support we have to do one object at a time and its not performance efficient.
    // in-case of native query we are not going to use persistence context
    public List<Customer> findAllCustomersByNativeQuery(){
        Query query = entityManager.createNativeQuery("select * from customer", Customer.class);
        return query.getResultList();
    }

    public List<Customer> findCustomersByNativeQueryParameter(Long id){
        Query query = entityManager.createNativeQuery("select * from customer where id = ?", Customer.class);
        query.setParameter(1, id);
        return query.getResultList();
    }

    public List<Customer> findCustomersByNativeQueryNamedParameter(Long id){
        Query query = entityManager.createNativeQuery("select * from customer where id = :id", Customer.class);
        query.setParameter("id", id);
        return query.getResultList();
    }



}
