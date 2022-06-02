package com.example.taxibooking.mapper;


import com.example.taxibooking.dto.NotificationDriverDto;
import com.example.taxibooking.model.NotificationDriver;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class})
public interface NotificationDriverMapper {
    NotificationDriverDto toNotificationDriverDto(NotificationDriver notificationDriver);
}