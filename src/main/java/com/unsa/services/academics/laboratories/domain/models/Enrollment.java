package com.unsa.services.academics.laboratories.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment {
    private Long id;
    private Long userId;
    private Long laboratoryId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
