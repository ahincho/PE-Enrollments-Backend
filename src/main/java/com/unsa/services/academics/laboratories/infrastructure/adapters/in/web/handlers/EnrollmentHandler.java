package com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.handlers;

import com.unsa.services.academics.laboratories.application.services.EnrollmentService;
import com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.dtos.EnrollmentCreateCommand;
import com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.dtos.EnrollmentResponse;
import com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.mappers.EnrollmentRestMapper;
import com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.routes.EnrollmentRoutes;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class EnrollmentHandler {
    private final EnrollmentService enrollmentService;
    public EnrollmentHandler(final EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }
    public Mono<ServerResponse> createOne(ServerRequest request) {
        Mono<EnrollmentCreateCommand> enrollmentCreateCommandMono = request.bodyToMono(EnrollmentCreateCommand.class);
        return enrollmentCreateCommandMono.flatMap(command ->
            enrollmentService.createOneEnrollment(EnrollmentRestMapper.createCommandToDomain(command))
                .flatMap(savedEnrollment -> ServerResponse
                    .created(URI.create(EnrollmentRoutes.PATH + "/" + savedEnrollment.getId()))
                    .bodyValue(EnrollmentRestMapper.domainToResponse(savedEnrollment))
                )
        ).switchIfEmpty(ServerResponse.badRequest().build());
    }
    public Mono<ServerResponse> getAll(ServerRequest request) {
        Flux<EnrollmentResponse> enrollments = enrollmentService.getAllEnrollments().map(EnrollmentRestMapper::domainToResponse);
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(enrollments, EnrollmentResponse.class);
    }
    public Mono<ServerResponse> getById(ServerRequest request) {
        Long id = Long.parseLong(request.pathVariable("enrollmentId"));
        Mono<EnrollmentResponse> enrollment = enrollmentService.getOneEnrollmentById(id).map(EnrollmentRestMapper::domainToResponse);
        return enrollment
            .flatMap(enr -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(enr))
            .switchIfEmpty(ServerResponse.notFound().build());
    }
    public Mono<ServerResponse> updateOne(ServerRequest request) {
        Long id = Long.parseLong(request.pathVariable("enrollmentId"));
        Mono<EnrollmentCreateCommand> enrollmentUpdateCommandMono = request.bodyToMono(EnrollmentCreateCommand.class);
        return enrollmentUpdateCommandMono.flatMap(command ->
            enrollmentService.updateOneEnrollment(id, EnrollmentRestMapper.createCommandToDomain(command))
                .then(ServerResponse.noContent().build())
        ).switchIfEmpty(ServerResponse.badRequest().build());
    }
    public Mono<ServerResponse> deleteOne(ServerRequest request) {
        Long id = Long.parseLong(request.pathVariable("enrollmentId"));
        return enrollmentService.deleteOneEnrollment(id)
            .then(ServerResponse.noContent().build());
    }
}
