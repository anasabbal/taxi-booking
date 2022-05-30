package com.example.taxibooking.service.customer;


import com.example.taxibooking.command.CustomerCommand;
import com.example.taxibooking.command.LocationCommand;
import com.example.taxibooking.exception.ExceptionPayload;
import com.example.taxibooking.model.Customer;
import com.example.taxibooking.model.Driver;
import com.example.taxibooking.model.ExactLocation;
import com.example.taxibooking.repository.CustomerRepository;
import com.example.taxibooking.service.driver.DriverService;
import com.example.taxibooking.service.location.LocationService;
import com.example.taxibooking.util.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final LocationService locationService;
    private final DriverService driverService;
    @Override
    public Customer save(CustomerCommand customerCommand) {
        log.info("Begin creating user with payload {}", JSONUtil.toJSON(customerCommand));
        final ExactLocation home = customerCommand.getHome() == null ? null : locationService.findById(customerCommand.getHome());
        final ExactLocation work = customerCommand.getWork() == null ? null : locationService.findById(customerCommand.getWork());
        final ExactLocation lastKnownLocation = customerCommand.getLastLocation() == null ? null : locationService.findById(customerCommand.getLastLocation());
        final Driver driver = customerCommand.getDriverCommand() == null ? null : driverService.findDriverById(customerCommand.getDriverCommand());

        final Customer customer = customerRepository.save(Customer.createUser(customerCommand, home, work, lastKnownLocation, driver));

        log.info("Finish creating user with payload {}", JSONUtil.toJSON(customer));

        return customer;
    }

    @Override
    public Customer findById(String customerId) {
        final Customer customer = customerRepository.findById(customerId).get();

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
}
