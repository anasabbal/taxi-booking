package com.example.taxibooking.service.driver;

import com.example.taxibooking.command.DriverCommand;
import com.example.taxibooking.model.Driver;

public interface DriverService {

    Driver createDriver(DriverCommand driverCommand);
}
