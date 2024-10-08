package com.unsa.services.academics.users.domain.exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("User not found");
    }
    public UserNotFoundException(Long id) {
        super("User with id " + id + " not found");
    }
}
