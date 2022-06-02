package com.example.taxibooking.service.customer;


import com.example.taxibooking.command.CustomerCommand;
import com.example.taxibooking.command.LocationCommand;
import com.example.taxibooking.dto.CustomerDto;
import com.example.taxibooking.enums.DriverStatus;
import com.example.taxibooking.enums.Rating;
import com.example.taxibooking.exception.BusinessException;
import com.example.taxibooking.exception.ExceptionPayloadFactory;
import com.example.taxibooking.mapper.CustomerMapper;
import com.example.taxibooking.mapper.NotificationCustomerMapper;
import com.example.taxibooking.model.*;
import com.example.taxibooking.repository.CustomerRepository;
import com.example.taxibooking.repository.DriverRepository;
import com.example.taxibooking.repository.NotificationCustomerRepository;
import com.example.taxibooking.repository.NotificationDriverRepository;
import com.example.taxibooking.service.driver.DriverService;
import com.example.taxibooking.service.location.LocationService;
import com.example.taxibooking.service.notification.customerNotif.CustomerNotificationService;
import com.example.taxibooking.util.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final LocationService locationService;
    private final DriverRepository driverRepository;
    private final NotificationDriverRepository notificationDriverRepository;

    @Override
    public Page<Customer> getAllCustomer(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    //@Transactional(readOnly = true)
    public Customer save(CustomerCommand customerCommand) {
        log.info("Begin creating user with payload {}", JSONUtil.toJSON(customerCommand));
        final ExactLocation home = customerCommand.getHome() == null ? null : locationService.findById(customerCommand.getHome());
        final ExactLocation work = customerCommand.getWork() == null ? null : locationService.findById(customerCommand.getWork());
        final ExactLocation lastKnownLocation = customerCommand.getLastLocation() == null ? null : locationService.findById(customerCommand.getLastLocation());
        //final Driver driver = customerCommand.getDriverCommand() == null ? null : driverService.findDriverById(customerCommand.getDriverCommand());

        final Driver driver = customerCommand.getDriverCommand() == null ? null :
                driverRepository.findById(customerCommand.getDriverCommand())
                        .orElseThrow(() -> new BusinessException(ExceptionPayloadFactory.DRIVER_NOT_FOUND.get()));

        final Customer customer = customerRepository.save(Customer.createUser(customerCommand, home, work, lastKnownLocation, driver));

        log.info("Finish creating user with payload {}", JSONUtil.toJSON(customer));

        return customer;
    }
    @Override
    public Customer addHomeLocation(String customerId, final LocationCommand locationCommand){
        final Customer customer = findById(customerId);

        final ExactLocation home = locationService.createLocation(locationCommand);

        customer.linkToHomeLocation(home);

        return customerRepository.save(customer);
    }

    @Override
    public Customer addWorkLocation(String customerId, LocationCommand locationCommand) {
        final Customer customer = findById(customerId);

        final ExactLocation work = locationService.createLocation(locationCommand);

        customer.linkToWorkLocation(work);

        return customerRepository.save(customer);
    }

    @Override
    public Customer addLastLocation(String customerId, LocationCommand locationCommand) {
        final Customer customer = findById(customerId);

        final ExactLocation last = locationService.createLocation(locationCommand);

        customer.linkToLastLocation(last);

        return customerRepository.save(customer);
    }

    @Override
    public Customer findById(String customerId) {
        log.info("Begin fetching customer with id {}", customerId);
        final Customer customer = customerRepository.findById(customerId).get();

        log.info("Fetching customer with payload {}", JSONUtil.toJSON(customer));
        return customer;
    }
    @Override
    public Customer updateCustomerLocation(String customerId, LocationCommand location) {
        final Customer customer = findById(customerId);

        ExactLocation exactLocation = ExactLocation.builder().longitude(location.getLongitude())
                .latitude(location.getLatitude())
                .build();
        customer.setLastKnownLocation(exactLocation);

        return customerRepository.save(customer);
    }

    @Override
    public Customer requestDriver(String driverId, String customerId) {
        final Customer customer = findById(customerId);
        final Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new BusinessException(ExceptionPayloadFactory.DRIVER_NOT_FOUND.get()));

        if(driver.getNotificationDriver() == null){
            final NotificationDriver notificationDriver = new NotificationDriver();
            log.info("Notification Driver with payload {}", JSONUtil.toJSON(notificationDriver));
            notificationDriver.linkToCustomer(customer);
            driver.linkToNotificationDriver(notificationDriver);
            driverRepository.save(driver);
            notificationDriverRepository.save(notificationDriver);
        }else {
            final NotificationDriver notificationDriver = driver.getNotificationDriver();
            notificationDriver.linkToCustomer(customer);
            driver.linkToNotificationDriver(notificationDriver);
            driverRepository.save(driver);
            log.info("driver with payload {}", JSONUtil.toJSON(driver));
            notificationDriverRepository.save(notificationDriver);
        }
        return customerRepository.save(customer);
    }
    @Override
    public Customer cancelRequest(String driverId, String customerId){
        final Customer customer = findById(customerId);
        final Driver driver =driverRepository.findById(driverId)
                .orElseThrow(() -> new BusinessException(ExceptionPayloadFactory.DRIVER_NOT_FOUND.get()));

        //customer.getNotificationCustomer().removeDriverForm(driver);
        final NotificationDriver notificationDriver = driver.getNotificationDriver();
        notificationDriver.removeFrom(customer);

        return customerRepository.save(customer);
    }

    @Override
    public String addRating_Driver(String driverId, String rating) {
        final Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new BusinessException(ExceptionPayloadFactory.DRIVER_NOT_FOUND.get()));

        driver.setRating(Rating.valueOf(rating));

        driverRepository.save(driver);

        return "rating driver with payload " + JSONUtil.toJSON(driver);
    }
}
