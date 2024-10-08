package com.unsa.services.academics.users.infrastructure.adapters.out.persistence;

import com.unsa.services.academics.users.application.ports.out.UserPersistencePort;
import com.unsa.services.academics.users.domain.models.User;
import com.unsa.services.academics.users.infrastructure.adapters.out.persistence.mappers.UserR2dbcMapper;
import com.unsa.services.academics.users.infrastructure.adapters.out.persistence.repositories.UserR2dbcRepository;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserPersistenceSqlAdapter implements UserPersistencePort {
    private final UserR2dbcRepository userR2dbcRepository;
    public UserPersistenceSqlAdapter(UserR2dbcRepository userR2dbcRepository) {
        this.userR2dbcRepository = userR2dbcRepository;
    }
    @Override
    public Mono<User> saveOneUser(User user) {
        return this.userR2dbcRepository.save(UserR2dbcMapper.toEntity(user)).map(UserR2dbcMapper::toDomain);
    }
    @Override
    public Flux<User> getAllUsers() {
        return this.userR2dbcRepository.findAll().map(UserR2dbcMapper::toDomain);
    }
    @Override
    public Mono<User> getOneUserById(Long id) {
        return this.userR2dbcRepository.findById(id).map(UserR2dbcMapper::toDomain);
    }
    @Override
    public Mono<User> getOneUserByEmail(String email) {
        return this.userR2dbcRepository.findByEmail(email).map(UserR2dbcMapper::toDomain);
    }
    @Override
    public Mono<Void> updateOneUser(Long id, User user) {
        return null;
    }
    @Override
    public Mono<Void> deleteOneUser(Long id) {
        return this.userR2dbcRepository.deleteById(id);
    }
}
