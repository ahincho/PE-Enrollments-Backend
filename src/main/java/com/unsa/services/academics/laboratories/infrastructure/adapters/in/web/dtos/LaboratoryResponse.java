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
public class LaboratoryResponse {
    private Long id;
    private Long courseId;
    private String section;
    private Integer capacity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
