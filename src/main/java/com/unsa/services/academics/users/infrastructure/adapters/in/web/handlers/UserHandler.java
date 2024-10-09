package com.unsa.services.academics.users.infrastructure.adapters.in.web.handlers;

import com.unsa.services.academics.users.application.services.UserService;
import com.unsa.services.academics.users.domain.models.User;
import com.unsa.services.academics.users.infrastructure.adapters.in.web.dtos.UserCreateCommand;
import com.unsa.services.academics.users.infrastructure.adapters.in.web.dtos.UserResponse;
import com.unsa.services.academics.users.infrastructure.adapters.in.web.mappers.UserRestMapper;
import com.unsa.services.academics.users.infrastructure.adapters.in.web.routes.UserRoutes;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class UserHandler {
    private final UserService userService;
    public UserHandler(UserService userService) {
        this.userService = userService;
    }
    public Mono<ServerResponse> createOne(ServerRequest request) {
        Mono<UserCreateCommand> userCreateCommandMono = request.bodyToMono(UserCreateCommand.class);
        return userCreateCommandMono.flatMap(command ->
            userService.createOneUser(UserRestMapper.createCommandToDomain(command))
                .flatMap(savedUser -> ServerResponse
                    .created(URI.create(UserRoutes.PATH + "/" + savedUser.getId()))
                    .bodyValue(UserRestMapper.toResponse(savedUser))));
    }
    public Mono<ServerResponse> getAll(ServerRequest request) {
        Flux<UserResponse> users = userService.getAllUsers().map(UserRestMapper::toResponse);
        return users.hasElements()
            .flatMap(hasUsers -> {
                if (hasUsers) {
                    return ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(users, UserResponse.class);
                } else {
                    return ServerResponse.noContent().build();
                }
            });
    }
    public Mono<ServerResponse> getById(ServerRequest request) {
        Long id = Long.parseLong(request.pathVariable("userId"));
        Mono<UserResponse> user = userService.getOneUserById(id).map(UserRestMapper::toResponse);
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(user, UserResponse.class)
            .switchIfEmpty(ServerResponse.notFound().build());
    }
    public Mono<ServerResponse> updateOne(ServerRequest request) {
        Long id = Long.parseLong(request.pathVariable("userId"));
        Mono<User> user = request.bodyToMono(User.class);
        return user.flatMap(u -> ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(userService.updateOneUser(id, u), User.class));
    }
    public Mono<ServerResponse> deleteOne(ServerRequest request) {
        Long id = Long.parseLong(request.pathVariable("userId"));
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(userService.deleteOneUser(id), User.class);
    }
}
