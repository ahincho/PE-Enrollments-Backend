package com.unsa.services.academics.laboratories.infrastructure.adapters.out.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "enrollments")
public class EnrollmentEntity {
    @Id
    private Long id;
    private Long userId;
    private Long laboratoryId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
