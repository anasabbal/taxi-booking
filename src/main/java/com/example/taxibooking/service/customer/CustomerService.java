package com.example.taxibooking.service.customer;

import com.example.taxibooking.command.CustomerCommand;
import com.example.taxibooking.command.LocationCommand;
import com.example.taxibooking.model.Account;
import com.example.taxibooking.model.Customer;
import com.example.taxibooking.model.Driver;
import com.example.taxibooking.payload.JwtSignUp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<Customer> getAllCustomer(Pageable pageable);
    Customer save(CustomerCommand customerCommand);
    Customer findById(String customerId);
    Customer updateCustomerLocation(String customerId, LocationCommand locationCommand);
    Customer requestDriver(String driverId, String customerId);
    Customer addHomeLocation(String customerId, final LocationCommand locationCommand);
    Customer addWorkLocation(String customerId, final LocationCommand locationCommand);
    Customer addLastLocation(String customerId, final LocationCommand locationCommand);
    Customer cancelRequest(String driverId, String customerId);

    String addRating_Driver(String driverId, String rating);

    Customer signup(JwtSignUp jwtSignUp);
}
