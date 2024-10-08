package com.unsa.services.academics.laboratories.infrastructure.adapters.out.persistence.repositories;

import com.unsa.services.academics.laboratories.domain.models.Enrollment;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentR2dbcRepository extends ReactiveCrudRepository<Enrollment, Long> {

}
