package com.example.taxibooking.dto;


import com.example.taxibooking.model.Driver;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class NotificationCustomerDto {
    private String id;
    private Set<DriverDto> drivers;
}
