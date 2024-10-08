package com.unsa.services.academics.laboratories.infrastructure.adapters.out.persistence;

import com.unsa.services.academics.laboratories.application.ports.out.EnrollmentPersistencePort;
import com.unsa.services.academics.laboratories.domain.models.Enrollment;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EnrollmentPersistenceSqlAdapter implements EnrollmentPersistencePort {
    @Override
    public Mono<Enrollment> saveOneEnrollment(Enrollment enrollment) {
        return null;
    }
    @Override
    public Flux<Enrollment> getAllEnrollments() {
        return null;
    }
    @Override
    public Mono<Enrollment> getOneEnrollmentById(Long id) {
        return null;
    }
    @Override
    public Mono<Void> updateOneEnrollment(Long id, Enrollment enrollment) {
        return null;
    }
    @Override
    public Mono<Void> deleteOneEnrollment(Long id) {
        return null;
    }
}
