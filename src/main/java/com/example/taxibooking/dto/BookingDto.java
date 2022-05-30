package com.example.taxibooking.dto;



import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class BookingDto {
    private CustomerDto customer;
    private DriverDto driver;
    private Set<DriverDto> notifiedDrivers;
}
