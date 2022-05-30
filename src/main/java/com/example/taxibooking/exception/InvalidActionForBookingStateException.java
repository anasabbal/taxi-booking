package com.example.taxibooking.exception;

public class InvalidActionForBookingStateException extends RuntimeException{
    public InvalidActionForBookingStateException(String message) {
        super(message);
    }
}
