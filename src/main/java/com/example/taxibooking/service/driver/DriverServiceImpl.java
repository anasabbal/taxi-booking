package com.example.taxibooking.service.driver;


import com.example.taxibooking.command.DriverCommand;
import com.example.taxibooking.command.LocationCommand;
import com.example.taxibooking.dto.CustomerDto;
import com.example.taxibooking.dto.DriverDto;
import com.example.taxibooking.enums.DriverApproveStatus;
import com.example.taxibooking.exception.BusinessException;
import com.example.taxibooking.exception.ExceptionPayloadFactory;
import com.example.taxibooking.mapper.CustomerMapper;
import com.example.taxibooking.mapper.DriverMapper;
import com.example.taxibooking.model.*;
import com.example.taxibooking.repository.CustomerRepository;
import com.example.taxibooking.repository.DriverRepository;
import com.example.taxibooking.repository.LocationRepository;
import com.example.taxibooking.repository.NotificationCustomerRepository;
import com.example.taxibooking.service.customer.CustomerService;
import com.example.taxibooking.service.location.LocationService;
import com.example.taxibooking.util.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService{
    private final DriverRepository driverRepository;
    private final LocationService locationService;
    private final DriverMapper driverMapper;
    private final CustomerService customerService;
    private final NotificationCustomerRepository notificationCustomerRepository;

    @Override
    public Page<DriverDto> getAllDriver(Pageable pageable) {
        Page<Driver> drivers = driverRepository.findAll(pageable);
        return drivers.map(driverMapper::toDriverDto);
    }

    @Override
    public Driver createDriver(DriverCommand driverCommand) {
        log.info("Begin creating driver with payload {}", JSONUtil.toJSON(driverCommand));

        final ExactLocation lastLocation = driverCommand.getLastLocation() == null ? null : locationService.findById(driverCommand.getLastLocation());
        final ExactLocation home = driverCommand.getDirection() == null ? null : locationService.findById(driverCommand.getDirection());
        final Driver driver = driverRepository.save(Driver.createDriver(driverCommand, lastLocation, home));

        return driver;
    }
    @Override
    public Driver findDriverById(String driverId) {
        final Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new BusinessException(ExceptionPayloadFactory.DRIVER_NOT_FOUND.get()));

        return  driver;
    }
    @Override
    public Driver addLastLocationToDriver(String driverId, LocationCommand locationCommand){
        final ExactLocation lastLocation = locationService.createLocation(locationCommand);

        final Driver driver = findDriverById(driverId);
        driver.linkToLastLocation(lastLocation);
        log.info("creating and adding lastLocation with payload {} to driver with id {}", JSONUtil.toJSON(locationCommand), driverId);

        return driverRepository.save(driver);
    }
    @Override
    public Driver addHomeLocationToDriver(String driverId, LocationCommand locationCommand){
        final ExactLocation home = locationService.createLocation(locationCommand);

        final Driver driver = findDriverById(driverId);
        driver.linkToHomeLocation(home);
        log.info("creating and adding lastLocation with payload {} to driver with id {}", JSONUtil.toJSON(locationCommand), driverId);

        return driverRepository.save(driver);
    }

    @Override
    public Page<Customer> getAllRequestCustomers(String driverId) {
        log.info("Begin fetch Driver with id {}", driverId);
        final Driver driver = findDriverById(driverId);
        final Set<Customer> customer = driver.getNotificationDriver().getCustomers();

        Page<Customer> customers = new PageImpl<>(new ArrayList<>(customer));

        return customers;
    }
    @Override
    public Page<Customer> cancelCustomerIdRequest(String driverId, String customerId){
        Page<Customer> customers = getAllRequestCustomers(driverId);
        Set<Customer> customers1 = customers.toSet();

        for(Customer customer: customers1){
            if(customer.getId().equals(customerId))
                customers1.remove(customer);
        }
        customers = new PageImpl<>(new ArrayList<>(customers1));
        return customers;
    }
    @Override
    public Driver updateDriverLocation(String driverId, LocationCommand location) {
        log.info("Fetch driver with id {}", driverId);
        final Driver driver = findDriverById(driverId);

        ExactLocation exactLocation = ExactLocation.builder().longitude(location.getLongitude())
                .latitude(location.getLatitude())
                .build();
        driver.setLastKnownLocation(exactLocation);
        return driverRepository.save(driver);
    }
    @Override
    public Driver acceptRequest_end_start_ride(String driverId, String customerId){
        final Customer customer = customerService.findById(customerId);
        final Driver driver = findDriverById(driverId);

        final NotificationCustomer notificationCustomer;
        if(customer.getNotificationCustomer() == null){
            notificationCustomer = new NotificationCustomer();
        }else{
            notificationCustomer = customer.getNotificationCustomer();
        }
        driver.setDriverApproveStatus(DriverApproveStatus.IN_RIDE);
        driver.setIsAvailable(Boolean.FALSE);

        notificationCustomer.linkToDriverNotification(driver);
        notificationCustomerRepository.save(notificationCustomer);
        customer.linkToDriver(driver);

        return driverRepository.save(driver);
    }
    public void end_ride_with_client(String driverId, String customerId){
        final Driver driver = findDriverById(driverId);
        final Customer customer = customerService.findById(customerId);


        driver.setIsAvailable(Boolean.TRUE);
        driver.setDriverApproveStatus(DriverApproveStatus.COMPLETED);
        driver.setLastKnownLocation(customer.getWork());
    }
}
