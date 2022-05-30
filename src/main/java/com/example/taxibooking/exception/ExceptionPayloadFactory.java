package com.example.taxibooking.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ExceptionPayloadFactory {
    TECHNICAL_ERROR(0, HttpStatus.INTERNAL_SERVER_ERROR, "technical.error"),
    INVALID_PAYLOAD(1, HttpStatus.BAD_REQUEST, "invalid.request.payload"),

    // Employee :
    EMPLOYEE_NOT_FOUND(5, HttpStatus.NOT_FOUND, "EMPLOYEE.not.found"),

    // Holiday :
    HOLIDAY_NOT_FOUND(5, HttpStatus.NOT_FOUND, "holiday.not.found"),

    // EMAIL :
    EMAIL_NOT_FOUND(5, HttpStatus.NOT_FOUND, "email.not.found"),

    LOCATION_NOT_FOUND(5, HttpStatus.NOT_FOUND, "location.not.found"),

    BOOKING_NOT_FOUND(5, HttpStatus.NOT_FOUND, "booking.not.found"),

    DRIVER_NOT_FOUND(5, HttpStatus.NOT_FOUND, "driver.not.found");



    private final Integer code;
    private final HttpStatus status;
    private final String message;

    public ExceptionPayload get() {
        return new ExceptionPayload(code, status, message);
    }

}
