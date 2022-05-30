package com.example.taxibooking.mapper;


import com.example.taxibooking.dto.BookingDto;
import com.example.taxibooking.model.Booking;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class, DriverMapper.class})
public interface BookingMapper {
    BookingDto toBookingDto(Booking booking);
}
