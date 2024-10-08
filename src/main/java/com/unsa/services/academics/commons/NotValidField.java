package com.unsa.services.academics.commons;

import org.springframework.validation.FieldError;

public record NotValidField(String field, String message) {
    public NotValidField(FieldError fieldError) {
        this(fieldError.getField(), fieldError.getDefaultMessage());
    }
}
