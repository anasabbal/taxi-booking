package com.example.taxibooking.service.driver;

import com.example.taxibooking.command.DriverCommand;
import com.example.taxibooking.command.LocationCommand;
import com.example.taxibooking.model.Driver;
import com.example.taxibooking.model.ExactLocation;

public interface DriverService {

    Driver createDriver(DriverCommand driverCommand);

    Driver findDriverById(String driverId);

    Driver updateDriverLocation(String driverId, LocationCommand location);
}
