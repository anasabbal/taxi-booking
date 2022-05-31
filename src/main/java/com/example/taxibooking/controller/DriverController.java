package com.example.taxibooking.controller;


import com.example.taxibooking.dto.DriverDto;
import com.example.taxibooking.mapper.DriverMapper;
import com.example.taxibooking.model.Driver;
import com.example.taxibooking.service.driver.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
