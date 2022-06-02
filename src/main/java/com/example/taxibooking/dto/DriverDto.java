package com.example.taxibooking.dto;


import com.example.taxibooking.enums.Rating;
import com.example.taxibooking.model.NotificationDriver;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class DriverDto {
    private String id;
    private String status;
    private String driverApproveStatus;
    private String password;
    private String driverType;
    private String rating;
    private LocationDto lastKnownLocation;
    private LocationDto home;
    private Boolean isAvailable;
    //private NotificationDriverDto notificationDriver;
}
