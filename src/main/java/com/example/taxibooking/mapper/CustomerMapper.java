package com.example.taxibooking.mapper;


import com.example.taxibooking.dto.CustomerDto;
import com.example.taxibooking.model.Customer;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DriverMapper.class})
public interface CustomerMapper {
    CustomerDto toCustomerDto(Customer customer);
}
