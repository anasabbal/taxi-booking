package com.example.taxibooking.dto;



import com.example.taxibooking.enums.Gender;
import com.example.taxibooking.enums.UserType;
import com.example.taxibooking.model.Driver;
import com.example.taxibooking.model.NotificationCustomer;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter
@Setter
public class CustomerDto {
    private String id;
    private String firstName;
    private String phone;
    private Gender gender;
    private LocationDto home;
    private LocationDto work, lastKnownLocation;
    private DriverDto driver;
}
