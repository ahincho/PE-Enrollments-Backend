package com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.handlers;

import com.unsa.services.academics.laboratories.application.services.CourseService;
import com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.dtos.CourseCreateCommand;
import com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.dtos.CourseResponse;
import com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.mappers.CourseRestMapper;
import com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.routes.CourseRoutes;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class CourseHandler {
    private final CourseService courseService;
    public CourseHandler(final CourseService courseService) {
        this.courseService = courseService;
    }
    public Mono<ServerResponse> createOne(ServerRequest request) {
        Mono<CourseCreateCommand> courseCreateCommandMono = request.bodyToMono(CourseCreateCommand.class);
        return courseCreateCommandMono.flatMap(command ->
            courseService.createOneCourse(CourseRestMapper.createCommandToDomain(command))
                .flatMap(savedCourse -> ServerResponse
                    .created(URI.create(CourseRoutes.PATH + "/" + savedCourse.getId()))
                    .bodyValue(CourseRestMapper.toResponse(savedCourse))
                )
        ).switchIfEmpty(ServerResponse.badRequest().build());
    }
    public Mono<ServerResponse> getAll(ServerRequest request) {
        Flux<CourseResponse> courses = courseService.getAllCourses().map(CourseRestMapper::toResponse);
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(courses, CourseResponse.class);
    }
    public Mono<ServerResponse> getById(ServerRequest request) {
        Long id = Long.parseLong(request.pathVariable("courseId"));
        Mono<CourseResponse> course = courseService.getOneCourseById(id).map(CourseRestMapper::toResponse);
        return course
            .flatMap(c -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(c))
            .switchIfEmpty(ServerResponse.notFound().build());
    }
    public Mono<ServerResponse> updateOne(ServerRequest request) {
        Long id = Long.parseLong(request.pathVariable("courseId"));
        Mono<CourseCreateCommand> courseUpdateCommandMono = request.bodyToMono(CourseCreateCommand.class);
        return courseUpdateCommandMono.flatMap(command ->
            courseService.updateOneCourse(id, CourseRestMapper.createCommandToDomain(command))
                .then(ServerResponse.noContent().build())
        ).switchIfEmpty(ServerResponse.badRequest().build());
    }
    public Mono<ServerResponse> deleteOne(ServerRequest request) {
        Long id = Long.parseLong(request.pathVariable("courseId"));
        return courseService.deleteOneCourse(id)
            .then(ServerResponse.noContent().build());
    }
}
