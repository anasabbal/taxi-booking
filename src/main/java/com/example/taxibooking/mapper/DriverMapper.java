package com.example.taxibooking.mapper;


import com.example.taxibooking.dto.DriverDto;
import com.example.taxibooking.dto.NotificationDriverDto;
import com.example.taxibooking.model.Driver;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {LocationMapper.class})
public interface DriverMapper {
    DriverDto toDriverDto(Driver driver);
}
