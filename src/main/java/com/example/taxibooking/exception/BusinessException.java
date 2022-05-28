package com.example.taxibooking.exception;

public class BusinessException extends RuntimeException{
    private final ExceptionPayload payload;

    public BusinessException(ExceptionPayload payload) {
        this.payload = payload;
    }
}
