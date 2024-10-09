package com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.mappers;

import com.unsa.services.academics.laboratories.domain.models.Course;
import com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.dtos.CourseCreateCommand;
import com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.dtos.CourseResponse;

public class CourseRestMapper {
    public static Course createCommandToDomain(CourseCreateCommand courseCreateCommand) {
        return Course.builder()
            .name(courseCreateCommand.name())
            .build();
    }
    public static CourseResponse toResponse(Course course) {
        return CourseResponse.builder()
            .id(course.getId())
            .name(course.getName())
            .createdAt(course.getCreatedAt())
            .updatedAt(course.getUpdatedAt())
            .build();
    }
}
