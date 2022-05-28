package com.example.taxibooking.exception;

import org.springframework.http.HttpStatus;

public class ExceptionPayload {
    private Integer code;
    private HttpStatus status;
    private String message;
    private String reference;

    public ExceptionPayload(Integer code, HttpStatus status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

}
