package com.unsa.services.academics.laboratories.infrastructure.adapters.in.web;

import com.unsa.services.academics.laboratories.application.ports.in.CourseServicePort;
import com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.dtos.CourseCreateCommand;
import com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.dtos.CourseResponse;
import com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.mappers.CourseRestMapper;

import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseRestController {
    private final CourseServicePort courseServicePort;
    public CourseRestController(CourseServicePort courseServicePort) {
        this.courseServicePort = courseServicePort;
    }
    @PostMapping
    public Mono<CourseResponse> createOneCourse(@RequestBody CourseCreateCommand courseCreateCommand) {
        return this.courseServicePort.createOneCourse(CourseRestMapper.createCommandToDomain(courseCreateCommand)).map(CourseRestMapper::toResponse);
    }
    @GetMapping
    public Flux<CourseResponse> getAllCourses() {
        return this.courseServicePort.getAllCourses().map(CourseRestMapper::toResponse);
    }
    @GetMapping("/{courseId}")
    public Mono<CourseResponse> getOneCourse(@PathVariable Long courseId) {
        return this.courseServicePort.getOneCourseById(courseId).map(CourseRestMapper::toResponse);
    }
    @PatchMapping("/{courseId}")
    public Mono<Void> updateOneCourse(@PathVariable Long courseId, @RequestBody CourseCreateCommand courseCreateCommand) {
        return this.courseServicePort.updateOneCourse(courseId, CourseRestMapper.createCommandToDomain(courseCreateCommand));
    }
    @DeleteMapping("/{courseId}")
    public Mono<Void> deleteOneCourse(@PathVariable Long courseId) {
        return this.courseServicePort.deleteOneCourse(courseId);
    }
}
