package com.example.taxibooking.mapper;


import com.example.taxibooking.dto.LocationDto;
import com.example.taxibooking.model.ExactLocation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    LocationDto toLocationDto(ExactLocation exactLocation);
}
