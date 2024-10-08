package com.unsa.services.academics.users.application.ports.in;

import com.unsa.services.academics.users.domain.models.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserServicePort {
    Mono<User> createOneUser(User user);
    Flux<User> getAllUsers();
    Mono<User> getOneUserById(Long id);
    Mono<Void> updateOneUser(Long id, User user);
    Mono<Void> deleteOneUser(Long id);
}
