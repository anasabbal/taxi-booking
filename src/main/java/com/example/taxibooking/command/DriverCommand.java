package com.example.taxibooking.command;


import com.example.taxibooking.enums.DriverStatus;
import com.example.taxibooking.enums.DriverType;
import com.example.taxibooking.model.Booking;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class DriverCommand {
    private DriverStatus status;
    private DriverType driverType;
    private String lastLocation;
    private String direction;
    private List<Booking> bookings; // bookings that the driver actually drove
    private Set<Booking> acceptableBookings = new HashSet<>(); // bookings that the driver can currently accept
    private Boolean isAvailable;
}
