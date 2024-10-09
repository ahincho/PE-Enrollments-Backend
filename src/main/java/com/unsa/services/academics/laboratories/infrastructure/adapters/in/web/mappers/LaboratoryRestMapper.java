package com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.mappers;

import com.unsa.services.academics.laboratories.domain.models.Laboratory;
import com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.dtos.LaboratoryCreateCommand;
import com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.dtos.LaboratoryResponse;

public class LaboratoryRestMapper {
    public static Laboratory createCommandToDomain(LaboratoryCreateCommand laboratoryCreateCommand) {
        return Laboratory.builder()
            .courseId(laboratoryCreateCommand.courseId())
            .section(laboratoryCreateCommand.section())
            .capacity(laboratoryCreateCommand.capacity())
            .build();
    }
    public static LaboratoryResponse domainToResponse(Laboratory laboratory) {
        return LaboratoryResponse.builder()
            .id(laboratory.getId())
            .courseId(laboratory.getCourseId())
            .section(laboratory.getSection())
            .capacity(laboratory.getCapacity())
            .createdAt(laboratory.getCreatedAt())
            .updatedAt(laboratory.getUpdatedAt())
            .build();
    }
}
