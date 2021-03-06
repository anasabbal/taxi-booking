package com.example.taxibooking.controller;


import com.example.taxibooking.command.CustomerCommand;
import com.example.taxibooking.command.LocationCommand;
import com.example.taxibooking.dto.CustomerDto;
import com.example.taxibooking.mapper.CustomerMapper;
import com.example.taxibooking.model.Customer;
import com.example.taxibooking.model.Driver;
import com.example.taxibooking.payload.JwtSignUp;
import com.example.taxibooking.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import okhttp3.internal.connection.RealConnectionPool;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;


    @GetMapping("/all")
    public ResponseEntity<Page<CustomerDto>> getAll(Pageable pageable){
        final Page<Customer> customer = customerService.getAllCustomer(pageable);
        return ResponseEntity.ok(customer.map(customerMapper::toCustomerDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getById(@PathVariable("id") String id){
        final Customer customer = customerService.findById(id);

        return ResponseEntity.ok(customerMapper.toCustomerDto(customer));
    }
    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody final CustomerCommand customerCommand){
        final Customer customer = customerService.save(customerCommand);

        return ResponseEntity.ok(customerMapper.toCustomerDto(customer));
    }
    @PostMapping("/HomeLocation/{customerId}")
    public ResponseEntity<CustomerDto> addHomeLocationToCustomer(@PathVariable("customerId") final String customerId,
                                                                 @RequestBody final LocationCommand locationCommand){
        final Customer customer = customerService.addHomeLocation(customerId, locationCommand);

        return ResponseEntity.ok(customerMapper.toCustomerDto(customer));
    }
    @PostMapping("/WorkLocation/{customerId}")
    public ResponseEntity<CustomerDto> addWorkLocationToCustomer(@PathVariable("customerId") final String customerId,
                                                                 @RequestBody final LocationCommand locationCommand){
        final Customer customer = customerService.addWorkLocation(customerId, locationCommand);

        return ResponseEntity.ok(customerMapper.toCustomerDto(customer));
    }
    @PostMapping("/LastLocation/{customerId}")
    public ResponseEntity<CustomerDto> addLastLocationToCustomer(@PathVariable("customerId") final String customerId,
                                                                 @RequestBody final LocationCommand locationCommand){
        final Customer customer = customerService.addLastLocation(customerId, locationCommand);

        return ResponseEntity.ok(customerMapper.toCustomerDto(customer));
    }
    @PutMapping("/location/{customerId}")
    public ResponseEntity<CustomerDto> updateLastLocationForCustomer(@PathVariable("customerId") final String customerId,
                                                                 @RequestBody final LocationCommand locationCommand){

        final Customer customer = customerService.updateCustomerLocation(customerId, locationCommand);
        return ResponseEntity.ok(customerMapper.toCustomerDto(customer));
    }
    @PostMapping("/request/driver/{driverId}/{customerId}")
    public ResponseEntity<CustomerDto> requestDriver(@PathVariable("customerId")final String customerId,
                                                     @PathVariable("driverId") String driverId){
        final Customer customer = customerService.requestDriver(driverId, customerId);

        return ResponseEntity.ok(customerMapper.toCustomerDto(customer));
    }
    @DeleteMapping("/cancel/driver/{driverId}/{customerId}")
    public ResponseEntity<CustomerDto> cancelRequest(@PathVariable("customerId")final String customerId,
                                                     @PathVariable("driverId") String driverId){
        final Customer customer = customerService.cancelRequest(driverId, customerId);

        return ResponseEntity.ok(customerMapper.toCustomerDto(customer));
    }
    @PostMapping("/rating/{driverId}")
    public ResponseEntity<String> addRatingToDriver(@PathVariable("driverId") final String driverId, String rating){
        return ResponseEntity.ok(customerService.addRating_Driver(driverId, rating));
    }
    /*@PostMapping("/signup")
    public ResponseEntity<CustomerDto> signup(@RequestBody JwtSignUp jwtSignUp){
        final Customer customer = customerService.signup(jwtSignUp);

        return ResponseEntity.ok(customerMapper.toCustomerDto(customer));
    }*/
}