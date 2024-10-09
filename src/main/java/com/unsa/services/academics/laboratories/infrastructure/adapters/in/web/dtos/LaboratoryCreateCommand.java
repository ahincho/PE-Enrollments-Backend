package com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LaboratoryCreateCommand(
    @NotNull(message = "Course ID must not be null")
    @Min(value = 1, message = "User ID must be greater than 0")
    Long courseId,
    @NotNull(message = "Group must no be null")
    @Size(min = 1, max = 2, message = "Section must contain 1 char or 2 chars at least")
    String section,
    @Min(value = 1, message = "Capacity must be greater than 0")
    Integer capacity
) { }
