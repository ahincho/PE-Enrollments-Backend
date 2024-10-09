package com.unsa.services.academics.users.application.ports.out;

import com.unsa.services.academics.users.domain.models.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserPersistencePort {
    Mono<User> saveOneUser(User user);
    Flux<User> getAllUsers();
    Mono<User> getOneUserById(Long id);
    Mono<User> getOneUserByEmail(String email);
    Mono<Void> updateOneUser(Long id, User user);
    Mono<Void> deleteOneUser(Long id);
}
