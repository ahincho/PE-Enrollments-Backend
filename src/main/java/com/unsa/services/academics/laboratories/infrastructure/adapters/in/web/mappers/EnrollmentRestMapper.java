package com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.mappers;

import com.unsa.services.academics.laboratories.domain.models.Enrollment;
import com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.dtos.EnrollmentCreateCommand;
import com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.dtos.EnrollmentResponse;

public class EnrollmentRestMapper {
    public static Enrollment createCommandToDomain(EnrollmentCreateCommand enrollmentCreateCommand) {
        return Enrollment.builder()
            .userId(enrollmentCreateCommand.userId())
            .laboratoryId(enrollmentCreateCommand.laboratoryId())
            .build();
    }
    public static EnrollmentResponse domainToResponse(Enrollment enrollment) {
        return EnrollmentResponse.builder()
            .id(enrollment.getId())
            .userId(enrollment.getUserId())
            .laboratoryId(enrollment.getLaboratoryId())
            .createdAt(enrollment.getCreatedAt())
            .updatedAt(enrollment.getUpdatedAt())
            .build();
    }
}
