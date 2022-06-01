package com.example.taxibooking.mapper;


import com.example.taxibooking.dto.NotificationCustomerDto;
import com.example.taxibooking.model.NotificationCustomer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {DriverMapper.class, CustomerMapper.class})
public interface NotificationCustomerMapper {
    NotificationCustomerDto toNotificationCustomerDto(NotificationCustomer notificationCustomer);
}
