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
@Table(name = "laboratories")
public class LaboratoryEntity {
    @Id
    private Long id;
    private Long courseId;
    private String section;
    private Integer capacity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
