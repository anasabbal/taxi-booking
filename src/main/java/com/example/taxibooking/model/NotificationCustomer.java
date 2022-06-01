package com.example.taxibooking.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NotificationCustomer {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @OneToMany
    @JoinColumn
    @JsonIgnore
    private Set<Driver> drivers = new HashSet<>();

    public void linkToDriverNotification(Driver driver){
        this.drivers.add(driver);
    }
    public void removeDriverForm(Driver driver){
        this.drivers.remove(driver);
    }
}
