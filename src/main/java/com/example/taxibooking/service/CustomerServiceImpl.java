package com.example.taxibooking.service;


import com.example.taxibooking.command.CustomerCommand;
import com.example.taxibooking.model.Customer;
import com.example.taxibooking.repository.CustomerRepository;
import com.example.taxibooking.util.JSONUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    @Override
    public Customer save(CustomerCommand customerCommand) {
        log.info("Begin creating user with payload {}", JSONUtil.toJSON(customerCommand));
        final Customer customer = customerRepository.save(Customer.createUser(customerCommand));

        log.info("Finish creating user with payload {}", JSONUtil.toJSON(customer));

        return customer;
    }
}
