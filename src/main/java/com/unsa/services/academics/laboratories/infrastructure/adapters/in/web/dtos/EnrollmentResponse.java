package com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentResponse {
    private Long id;
    private Long userId;
    private Long laboratoryId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
