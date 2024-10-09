package com.unsa.services.academics.laboratories.infrastructure.adapters.out.persistence.repositories;

import com.unsa.services.academics.laboratories.infrastructure.adapters.out.persistence.entities.EnrollmentEntity;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentR2dbcRepository extends ReactiveCrudRepository<EnrollmentEntity, Long> {

}
