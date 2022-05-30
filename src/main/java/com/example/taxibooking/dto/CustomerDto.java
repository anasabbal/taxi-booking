package com.example.taxibooking.dto;



import com.example.taxibooking.enums.Gender;
import com.example.taxibooking.enums.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {
    private String id;
    private String firstName;
    private String email;
    private String phone;
    private UserType role;
    private Gender gender;
    private LocationDto home;
    private LocationDto work;
    private LocationDto lastLocation;
    private DriverDto driverDto;
}
