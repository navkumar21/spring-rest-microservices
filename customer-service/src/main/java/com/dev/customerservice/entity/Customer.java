package com.dev.customerservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NamedQueries( value = {
        @NamedQuery(name = Customer.SELECT_ALL_CUSTOMERS, query = Customer.SELECT_ALL_CUSTOMERS_QUERY)
})
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    //these date related annotations are part of hibernate, JPA doesn't have this.
    @UpdateTimestamp
    private LocalDateTime updateDate;
    @CreationTimestamp
    private LocalDateTime createdDate;

//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne (cascade = {CascadeType.ALL})
    private Identity identity;

    public static final String SELECT_ALL_CUSTOMERS = "SELECT_ALL_CUSTOMERS";
    public static final String SELECT_ALL_CUSTOMERS_QUERY = "select c from Customer c";
}
