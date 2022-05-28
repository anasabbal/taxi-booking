package com.example.taxibooking.service;

import com.example.taxibooking.command.CustomerCommand;
import com.example.taxibooking.model.Customer;

public interface CustomerService {

    Customer save(CustomerCommand customerCommand);
}
