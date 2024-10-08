package com.unsa.services.academics.laboratories.infrastructure.adapters.out.persistence.repositories;

import com.unsa.services.academics.laboratories.infrastructure.adapters.out.persistence.entities.CourseEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseR2dbcRepository extends ReactiveCrudRepository<CourseEntity, Long> {

}
