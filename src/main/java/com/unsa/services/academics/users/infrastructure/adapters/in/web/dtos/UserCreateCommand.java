package com.unsa.services.academics.users.infrastructure.adapters.in.web.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserCreateCommand(
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 32, message = "Name must contain 2 chars at least or 32 chars at max")
    String name,
    @NotBlank(message = "Lastname is required")
    @Size(min = 2, max = 32, message = "Name must contain 2 chars at least or 32 chars at max")
    String lastname,
    @NotBlank(message = "Email is required")
    @Email(message = "You must send a valid email")
    @Size(min = 2, max = 32, message = "Name must contain 2 chars at least or 32 chars at max")
    String email,
    @NotBlank(message = "Password is required")
    @Size(min = 2, max = 16, message = "Password must contain 2 chars at least or 16 chars at max")
    String password
) { }
