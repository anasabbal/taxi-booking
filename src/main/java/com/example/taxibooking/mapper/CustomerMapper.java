package com.example.taxibooking.mapper;


import com.example.taxibooking.dto.CustomerDto;
import com.example.taxibooking.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {LocationMapper.class})
public interface CustomerMapper {
    CustomerDto toCustomerDto(Customer customer);
}
