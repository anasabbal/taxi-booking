package com.example.taxibooking.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class NotificationCustomer {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @OneToMany
    private Set<Driver> drivers;

    public void linkToDriverNotification(Driver driver){
        this.drivers.add(driver);
    }
    public void removeDriverForm(Driver driver){
        this.drivers.remove(driver);
    }
}
