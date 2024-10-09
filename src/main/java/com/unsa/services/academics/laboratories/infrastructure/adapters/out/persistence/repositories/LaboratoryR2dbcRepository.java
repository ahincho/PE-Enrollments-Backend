package com.unsa.services.academics.laboratories.infrastructure.adapters.out.persistence.repositories;

import com.unsa.services.academics.laboratories.infrastructure.adapters.out.persistence.entities.LaboratoryEntity;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratoryR2dbcRepository extends ReactiveCrudRepository<LaboratoryEntity, Long> {

}
