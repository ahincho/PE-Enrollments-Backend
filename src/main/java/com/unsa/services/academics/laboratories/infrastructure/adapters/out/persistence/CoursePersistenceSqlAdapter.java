package com.unsa.services.academics.laboratories.infrastructure.adapters.out.persistence;

import com.unsa.services.academics.laboratories.application.ports.out.CoursePersistencePort;
import com.unsa.services.academics.laboratories.domain.models.Course;
import com.unsa.services.academics.laboratories.infrastructure.adapters.out.persistence.mappers.CourseR2dbcMapper;
import com.unsa.services.academics.laboratories.infrastructure.adapters.out.persistence.repositories.CourseR2dbcRepository;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CoursePersistenceSqlAdapter implements CoursePersistencePort {
    private final CourseR2dbcRepository courseR2dbcRepository;
    public CoursePersistenceSqlAdapter(CourseR2dbcRepository courseR2dbcRepository) {
        this.courseR2dbcRepository = courseR2dbcRepository;
    }
    @Override
    public Mono<Course> saveOneCourse(Course course) {
        return this.courseR2dbcRepository
            .save(CourseR2dbcMapper.toEntity(course))
            .map(CourseR2dbcMapper::toDomain);
    }
    @Override
    public Flux<Course> getAllCourses() {
        return this.courseR2dbcRepository
            .findAll()
            .map(CourseR2dbcMapper::toDomain);
    }
    @Override
    public Mono<Course> getOneCourseById(Long id) {
        return this.courseR2dbcRepository
            .findById(id)
            .map(CourseR2dbcMapper::toDomain);
    }
    @Override
    public Mono<Void> updateOneCourse(Long id, Course course) {
        return null;
    }
    @Override
    public Mono<Void> deleteOneCourse(Long id) {
        return this.courseR2dbcRepository
            .deleteById(id);
    }
}
