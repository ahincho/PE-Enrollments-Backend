package com.unsa.services.academics.laboratories.infrastructure.adapters.out.persistence.mappers;

import com.unsa.services.academics.laboratories.domain.models.Enrollment;
import com.unsa.services.academics.laboratories.infrastructure.adapters.out.persistence.entities.EnrollmentEntity;

public class EnrollmentR2dbcMapper {
    public static EnrollmentEntity toEntity(Enrollment enrollment) {
        return EnrollmentEntity.builder()
            .userId(enrollment.getUserId())
            .laboratoryId(enrollment.getLaboratoryId())
            .build();
    }
    public static Enrollment toDomain(EnrollmentEntity entity) {
        return Enrollment.builder()
            .id(entity.getUserId())
            .userId(entity.getUserId())
            .laboratoryId(entity.getLaboratoryId())
            .createdAt(entity.getCreatedAt())
            .updatedAt(entity.getUpdatedAt())
            .build();
    }
}
