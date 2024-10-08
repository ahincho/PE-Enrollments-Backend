package com.unsa.services.academics.commons;

import org.springframework.http.HttpStatus;

public class CustomException extends Exception {
    private final HttpStatus httpStatus;
    public CustomException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
