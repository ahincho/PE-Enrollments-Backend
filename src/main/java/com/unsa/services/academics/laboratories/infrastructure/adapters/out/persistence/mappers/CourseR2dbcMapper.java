package com.unsa.services.academics.laboratories.infrastructure.adapters.out.persistence.mappers;

import com.unsa.services.academics.laboratories.domain.models.Course;
import com.unsa.services.academics.laboratories.infrastructure.adapters.out.persistence.entities.CourseEntity;

public class CourseR2dbcMapper {
    public static CourseEntity toEntity(Course course) {
        return CourseEntity.builder()
            .name(course.getName())
            .build();
    }
    public static Course toDomain(CourseEntity entity) {
        return Course.builder()
            .id(entity.getId())
            .name(entity.getName())
            .createdAt(entity.getCreatedAt())
            .updatedAt(entity.getUpdatedAt())
            .build();
    }
}
