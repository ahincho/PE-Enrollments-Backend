package com.unsa.services.academics.users.application.services;

import com.unsa.services.academics.commons.CustomException;
import com.unsa.services.academics.users.application.ports.in.UserServicePort;
import com.unsa.services.academics.users.application.ports.out.UserPersistencePort;
import com.unsa.services.academics.users.domain.exceptions.UserNotFoundException;
import com.unsa.services.academics.users.domain.models.User;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService implements UserServicePort {
    private final UserPersistencePort userPersistencePort;
    public UserService(UserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }
    @Override
    public Mono<User> createOneUser(User user) {
        Mono<Boolean> existsEmail = this.userPersistencePort.getOneUserByEmail(user.getEmail()).hasElement();
        return existsEmail.flatMap(
            exists -> exists ?
                Mono.error(new CustomException(HttpStatus.BAD_REQUEST, "User with email " + user.getEmail() + " already exists")) :
                this.userPersistencePort.saveOneUser(user)
        );
    }
    @Override
    public Flux<User> getAllUsers() {
        return this.userPersistencePort.getAllUsers();
    }
    @Override
    public Mono<User> getOneUserById(Long id) {
        return this.userPersistencePort
            .getOneUserById(id)
            .switchIfEmpty(Mono.error(new UserNotFoundException(id)));
    }
    @Override
    public Mono<Void> updateOneUser(Long id, User user) {
        return this.userPersistencePort.updateOneUser(id, user);
    }
    @Override
    public Mono<Void> deleteOneUser(Long id) {
        return this.userPersistencePort.deleteOneUser(id);
    }
}
