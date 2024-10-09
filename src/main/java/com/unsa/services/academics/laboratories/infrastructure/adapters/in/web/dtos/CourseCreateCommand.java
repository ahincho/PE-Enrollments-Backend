package com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CourseCreateCommand(
    @NotBlank
    @Size(min = 2, max = 64, message = "Name must contain 2 chars at least or 64 chars at max")
    String name
) { }
