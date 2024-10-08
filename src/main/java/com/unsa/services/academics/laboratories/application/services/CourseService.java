package com.unsa.services.academics.laboratories.application.services;

import com.unsa.services.academics.laboratories.application.ports.in.CourseServicePort;
import com.unsa.services.academics.laboratories.application.ports.out.CoursePersistencePort;
import com.unsa.services.academics.laboratories.domain.models.Course;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CourseService implements CourseServicePort {
    private final CoursePersistencePort coursePersistencePort;
    public CourseService(CoursePersistencePort coursePersistencePort) {
        this.coursePersistencePort = coursePersistencePort;
    }
    @Override
    public Mono<Course> createOneCourse(Course course) {
        return this.coursePersistencePort.saveOneCourse(course);
    }
    @Override
    public Flux<Course> getAllCourses() {
        return this.coursePersistencePort.getAllCourses();
    }
    @Override
    public Mono<Course> getOneCourseById(Long id) {
        return this.coursePersistencePort.getOneCourseById(id);
    }
    @Override
    public Mono<Void> updateOneCourse(Long id, Course course) {
        return this.coursePersistencePort.updateOneCourse(id, course);
    }
    @Override
    public Mono<Void> deleteOneCourse(Long id) {
        return this.coursePersistencePort.deleteOneCourse(id);
    }
}
