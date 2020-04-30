package com.dev.customerservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

//one-to-one relationship always eager fetch

@Data
@Entity
public class Identity {

    @Id
    @GeneratedValue
    private Long id;
    private String identificationNumber;

    // mappedBy will tell us who owns the OneToOne relationship. always put mappedBy on non-owning side of the class, in below scenario Customer owns the owning relationship.
    // what ever the owning side property name we define it in mappedBy value.
    @JsonIgnore
    @OneToOne (fetch = FetchType.LAZY , mappedBy = "identity")
    private Customer customer;
}
