package com.example.taxibooking.command;


import com.example.taxibooking.enums.DriverStatus;
import com.example.taxibooking.enums.DriverType;
import com.example.taxibooking.enums.Rating;
import com.example.taxibooking.model.Booking;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class DriverCommand {
    private LocalDateTime startDriveWithClient;
    private LocalDateTime endTimeWithClient;
    private DriverStatus status;
    private DriverType driverType;
    private LocationCommand lastLocation;
    private LocationCommand direction;
    private List<Booking> bookings; // bookings that the driver actually drove
    private Set<Booking> acceptableBookings = new HashSet<>(); // bookings that the driver can currently accept
    private Boolean isAvailable;
}
