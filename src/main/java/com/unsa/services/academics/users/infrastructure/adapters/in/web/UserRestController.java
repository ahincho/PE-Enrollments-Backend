package com.unsa.services.academics.users.infrastructure.adapters.in.web;

import com.unsa.services.academics.users.application.services.UserService;
import com.unsa.services.academics.users.infrastructure.adapters.in.web.dtos.UserResponse;
import com.unsa.services.academics.users.infrastructure.adapters.in.web.mappers.UserRestMapper;
import com.unsa.services.academics.users.infrastructure.adapters.in.web.dtos.UserCreateCommand;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {
    private final UserService userServicePort;
    public UserRestController(final UserService userServicePort) {
        this.userServicePort = userServicePort;
    }
    @PostMapping
    public Mono<UserResponse> createOneUser(@RequestBody @Valid UserCreateCommand userCreateCommand) {
        return this.userServicePort.createOneUser(UserRestMapper.createCommandToDomain(userCreateCommand)).map(UserRestMapper::toResponse);
    }
    @GetMapping
    public Flux<UserResponse> findAllUsers() {
        return this.userServicePort.getAllUsers().map(UserRestMapper::toResponse);
    }
    @GetMapping("/{userId}")
    public Mono<UserResponse> findOneUser(@PathVariable long userId) {
        return this.userServicePort.getOneUserById(userId).map(UserRestMapper::toResponse);
    }
    @PatchMapping("/{userId}")
    public Mono<Void> updateOneUser(@PathVariable Long userId, @RequestBody @Valid UserCreateCommand userCreateCommand) {
        return this.userServicePort.updateOneUser(userId, UserRestMapper.createCommandToDomain(userCreateCommand));
    }
    @DeleteMapping("/{userId}")
    public Mono<Void> deleteOneUser(@PathVariable long userId) {
        return this.userServicePort.deleteOneUser(userId);
    }
}
