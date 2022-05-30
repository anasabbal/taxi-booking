package com.example.taxibooking.service.booking;

import com.example.taxibooking.dto.BookingDto;
import com.example.taxibooking.model.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookingService {
    Page<BookingDto> getAllBooking(Pageable pageable);
    Booking getBookingById(String bookingId);
}
