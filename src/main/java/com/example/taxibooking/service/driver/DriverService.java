package com.example.taxibooking.service.driver;

import com.example.taxibooking.command.DriverCommand;
import com.example.taxibooking.command.LocationCommand;
import com.example.taxibooking.dto.CustomerDto;
import com.example.taxibooking.dto.DriverDto;
import com.example.taxibooking.model.Customer;
import com.example.taxibooking.model.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DriverService {

    Page<DriverDto> getAllDriver(Pageable pageable);
    Driver createDriver(DriverCommand driverCommand);
    Driver findDriverById(String driverId);
    Driver updateDriverLocation(String driverId, LocationCommand location);
    public Driver addLastLocationToDriver(String driverId, LocationCommand locationCommand);
    public Driver addHomeLocationToDriver(String driverId, LocationCommand locationCommand);
    Page<Customer> getAllRequestCustomers(String driverId);
    Page<Customer> cancelCustomerIdRequest(String driverId, String customerId);
    Driver acceptRequest_end_start_ride(String customerId, String driverId);

}
