package com.example.taxibooking.dto;


import com.example.taxibooking.enums.Rating;
import com.example.taxibooking.model.Booking;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class DriverDto {
    private LocalDateTime startDriveWithClient;
    private LocalDateTime endTimeWithClient;
    private String status;
    private String driverType;
    private Rating rating;
    private LocationDto lastKnownLocation;
    private LocationDto home;
    private List<Booking> bookings; // bookings that the driver actually drove
    private Set<Booking> acceptableBookings; // bookings that the driver can currently accept
    private Boolean isAvailable;
}
