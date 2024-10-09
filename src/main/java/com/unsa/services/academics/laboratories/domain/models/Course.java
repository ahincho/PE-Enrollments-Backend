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
public class Course {
    private Long id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @Override
    public String toString() {
        return "Course [id=" + id + ", name=" + name + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }
}
