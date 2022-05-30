package com.example.taxibooking.service.customer;

import com.example.taxibooking.command.CustomerCommand;
import com.example.taxibooking.command.LocationCommand;
import com.example.taxibooking.model.Customer;

public interface CustomerService {

    Customer save(CustomerCommand customerCommand);

    Customer findById(String customerId);

    Customer updateCustomerLocation(String customerId, LocationCommand locationCommand);
}
