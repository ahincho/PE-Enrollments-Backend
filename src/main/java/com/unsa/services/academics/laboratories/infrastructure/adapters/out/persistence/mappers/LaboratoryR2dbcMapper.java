package com.unsa.services.academics.laboratories.infrastructure.adapters.out.persistence.mappers;

import com.unsa.services.academics.laboratories.domain.models.Laboratory;
import com.unsa.services.academics.laboratories.infrastructure.adapters.out.persistence.entities.LaboratoryEntity;

public class LaboratoryR2dbcMapper {
    public static LaboratoryEntity toEntity(Laboratory laboratory) {
        return LaboratoryEntity.builder()
            .courseId(laboratory.getCourseId())
            .section(laboratory.getSection())
            .capacity(laboratory.getCapacity())
            .build();
    }
    public static Laboratory toDomain(LaboratoryEntity entity) {
        return Laboratory.builder()
            .id(entity.getId())
            .courseId(entity.getCourseId())
            .section(entity.getSection())
            .capacity(entity.getCapacity())
            .build();
    }
}
