package com.example.taxibooking.controller;


import com.example.taxibooking.command.DriverCommand;
import com.example.taxibooking.command.LocationCommand;
import com.example.taxibooking.dto.CustomerDto;
import com.example.taxibooking.dto.DriverDto;
import com.example.taxibooking.mapper.DriverMapper;
import com.example.taxibooking.model.Driver;
import com.example.taxibooking.service.driver.DriverService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;

@RestController
@RequestMapping("/v1/driver")
@RequiredArgsConstructor
public class DriverController {
    private final DriverService driverService;
    private final DriverMapper driverMapper;


    @GetMapping("/all")
    public ResponseEntity<Page<DriverDto>> getAllDriver(Pageable pageable){
        return ResponseEntity.ok(driverService.getAllDriver(pageable));
    }
    @GetMapping("/{driverId}")
    public ResponseEntity<DriverDto> getDriverById(@PathVariable("driverId") final String driverId){
        final Driver driver = driverService.findDriverById(driverId);

        return ResponseEntity.ok(driverMapper.toDriverDto(driver));
    }
    @PostMapping
    public ResponseEntity<DriverDto> createDriver(@RequestBody DriverCommand driverCommand){
        final Driver driver = driverService.createDriver(driverCommand);

        return ResponseEntity.ok(driverMapper.toDriverDto(driver));
    }
    @PostMapping("/lastLocation/{driverId}")
    public ResponseEntity<DriverDto> addLastLocationToDriver(@PathVariable("driverId") final String driverId,
                                                             @RequestBody final LocationCommand locationCommand){
        final Driver driver = driverService.addLastLocationToDriver(driverId, locationCommand);

        return ResponseEntity.ok(driverMapper.toDriverDto(driver));
    }
    @PostMapping("/homeLocation/{driverId}")
    public ResponseEntity<DriverDto> addHomeLocationToDriver(@PathVariable("driverId") final String driverId,
                                                             @RequestBody final LocationCommand locationCommand){
        final Driver driver = driverService.addHomeLocationToDriver(driverId, locationCommand);

        return ResponseEntity.ok(driverMapper.toDriverDto(driver));
    }
    @PutMapping("/update/location/{driverId}")
    public ResponseEntity<DriverDto> updateLocationDriver(@PathVariable("driverId") final String driverId,
                                                          @RequestBody final LocationCommand locationCommand){
        final Driver driver = driverService.updateDriverLocation(driverId, locationCommand);
        return ResponseEntity.ok(driverMapper.toDriverDto(driver));
    }
    @GetMapping("/request/customers/{driverId}")
    public ResponseEntity<Page<CustomerDto>> getAllRequestCustomer(@PathVariable("driverId") final String driverId){
        return ResponseEntity.ok(driverService.getAllRequestCustomers(driverId));
    }
}
