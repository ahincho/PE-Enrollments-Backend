package com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record EnrollmentCreateCommand(
    @NotNull(message = "User ID must not be null")
    @Min(value = 1, message = "User ID must be greater than 0")
    Long userId,
    @NotNull(message = "Laboratory ID must not be null")
    @Min(value = 1, message = "Laboratory ID must be greater than 0")
    Long laboratoryId
) { }
