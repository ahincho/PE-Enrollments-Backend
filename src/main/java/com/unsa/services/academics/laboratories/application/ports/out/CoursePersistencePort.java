package com.unsa.services.academics.laboratories.application.ports.out;

import com.unsa.services.academics.laboratories.domain.models.Course;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CoursePersistencePort {
    Mono<Course> saveOneCourse(Course course);
    Flux<Course> getAllCourses();
    Mono<Course> getOneCourseById(Long id);
    Mono<Void> updateOneCourse(Long id, Course course);
    Mono<Void> deleteOneCourse(Long id);
}
