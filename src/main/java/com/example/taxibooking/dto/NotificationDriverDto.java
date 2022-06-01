package com.example.taxibooking.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
public class NotificationDriverDto {
    private String id;
    private Set<CustomerDto> customers;
}
