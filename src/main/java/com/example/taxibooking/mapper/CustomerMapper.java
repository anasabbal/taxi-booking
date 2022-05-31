package com.example.taxibooking.mapper;


import com.example.taxibooking.dto.CustomerDto;
import com.example.taxibooking.model.Customer;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring", uses = {DriverMapper.class, LocationMapper.class})
public interface CustomerMapper {
    CustomerDto toCustomerDto(Customer customer);
}
