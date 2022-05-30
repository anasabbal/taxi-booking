package com.example.taxibooking.model;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Booking extends AbstractEntity{

    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Driver driver;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Driver> notifiedDrivers = new HashSet<>(); // store which drivers can potentially accept this booking
}
