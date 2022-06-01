package com.example.taxibooking.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NotificationDriver {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private Set<Customer> customers;


    public void linkToCustomer(Customer customer){
        this.customers.add(customer);
    }
    public void removeFrom(Customer customer){
        this.customers.remove(customer);
    }
}
