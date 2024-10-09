package com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.handlers;

import com.unsa.services.academics.laboratories.application.services.LaboratoryService;
import com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.dtos.LaboratoryCreateCommand;
import com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.dtos.LaboratoryResponse;
import com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.mappers.LaboratoryRestMapper;
import com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.routes.LaboratoryRoutes;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class LaboratoryHandler {
    private final LaboratoryService laboratoryService;
    public LaboratoryHandler(final LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }
    public Mono<ServerResponse> createOne(ServerRequest request) {
        Mono<LaboratoryCreateCommand> laboratoryCreateCommandMono = request.bodyToMono(LaboratoryCreateCommand.class);

        return laboratoryCreateCommandMono.flatMap(command ->
            laboratoryService.createOneLaboratory(LaboratoryRestMapper.createCommandToDomain(command))
                .flatMap(savedLaboratory -> ServerResponse
                    .created(URI.create(LaboratoryRoutes.PATH + "/" + savedLaboratory.getId()))
                    .bodyValue(LaboratoryRestMapper.domainToResponse(savedLaboratory))
                )
        ).switchIfEmpty(ServerResponse.badRequest().build());
    }
    public Mono<ServerResponse> getAll(ServerRequest request) {
        Flux<LaboratoryResponse> laboratories = laboratoryService.getAllLaboratories().map(LaboratoryRestMapper::domainToResponse);
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(laboratories, LaboratoryResponse.class);
    }
    public Mono<ServerResponse> getById(ServerRequest request) {
        Long id = Long.parseLong(request.pathVariable("laboratoryId"));
        Mono<LaboratoryResponse> laboratory = laboratoryService.getOneLaboratoryById(id).map(LaboratoryRestMapper::domainToResponse);
        return laboratory
            .flatMap(lab -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(lab))
            .switchIfEmpty(ServerResponse.notFound().build());
    }
    public Mono<ServerResponse> updateOne(ServerRequest request) {
        Long id = Long.parseLong(request.pathVariable("laboratoryId"));
        Mono<LaboratoryCreateCommand> laboratoryUpdateCommandMono = request.bodyToMono(LaboratoryCreateCommand.class);
        return laboratoryUpdateCommandMono.flatMap(command ->
            laboratoryService.updateOneLaboratory(id, LaboratoryRestMapper.createCommandToDomain(command))
                .then(ServerResponse.noContent().build())
        ).switchIfEmpty(ServerResponse.badRequest().build());
    }
    public Mono<ServerResponse> deleteOne(ServerRequest request) {
        Long id = Long.parseLong(request.pathVariable("laboratoryId"));
        return laboratoryService.deleteOneLaboratory(id)
            .then(ServerResponse.noContent().build());
    }
}
