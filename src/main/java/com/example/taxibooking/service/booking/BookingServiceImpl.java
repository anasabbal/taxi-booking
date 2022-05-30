package com.example.taxibooking.service.booking;


import com.example.taxibooking.dto.BookingDto;
import com.example.taxibooking.exception.BusinessException;
import com.example.taxibooking.exception.ExceptionPayloadFactory;
import com.example.taxibooking.mapper.BookingMapper;
import com.example.taxibooking.model.Booking;
import com.example.taxibooking.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookingServiceImpl implements BookingService{

    private BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    @Override
    public Page<BookingDto> getAllBooking(Pageable pageable) {
        Page<Booking> bookings = bookingRepository.findAll(pageable);

        return bookings.map(bookingMapper::toBookingDto);
    }

    @Override
    public Booking getBookingById(String bookingId) {
        final Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new BusinessException(ExceptionPayloadFactory.BOOKING_NOT_FOUND.get()));
        return booking;
    }
}
