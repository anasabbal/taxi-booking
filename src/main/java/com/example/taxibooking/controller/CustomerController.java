package com.example.taxibooking.controller;


import com.example.taxibooking.dto.BookingDto;
import com.example.taxibooking.dto.CustomerDto;
import com.example.taxibooking.mapper.CustomerMapper;
import com.example.taxibooking.model.Customer;
import com.example.taxibooking.service.booking.BookingService;
import com.example.taxibooking.service.customer.CustomerService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;
    private final BookingService bookingService;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getById(@PathVariable("id") String id){
        final Customer customer = customerService.findById(id);

        return ResponseEntity.ok(customerMapper.toCustomerDto(customer));
    }
    @GetMapping("/booking/all")
    public ResponseEntity<Page<BookingDto>> getAllBooking(Pageable pageable){
        return ResponseEntity.ok(bookingService.getAllBooking(pageable));
    }
}
