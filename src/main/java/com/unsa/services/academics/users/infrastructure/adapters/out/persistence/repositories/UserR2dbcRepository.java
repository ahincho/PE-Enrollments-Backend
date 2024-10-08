package com.unsa.services.academics.users.infrastructure.adapters.out.persistence.repositories;

import com.unsa.services.academics.users.infrastructure.adapters.out.persistence.entities.UserEntity;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserR2dbcRepository extends ReactiveCrudRepository<UserEntity, Long> {

}
