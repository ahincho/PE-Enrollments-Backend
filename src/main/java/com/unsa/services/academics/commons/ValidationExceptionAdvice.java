package com.unsa.services.academics.commons;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

import java.util.List;

@RestControllerAdvice
public class ValidationExceptionAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Mono<ServerResponse> handleValidationExceptions(MethodArgumentNotValidException notValidException) {
        List<NotValidField> errors = notValidException.getFieldErrors()
                .stream()
                .map(NotValidField::new)
                .toList();
        System.out.println("Validation Advice");
        return ServerResponse
                .badRequest()
                .bodyValue(errors);
    }
}
