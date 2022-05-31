package com.example.taxibooking.command;


import com.example.taxibooking.enums.DriverStatus;
import com.example.taxibooking.enums.DriverType;
import lombok.Getter;
import lombok.Setter;

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
    private Boolean isAvailable;
}
