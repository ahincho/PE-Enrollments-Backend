package com.unsa.services.academics.laboratories.application.ports.out;

import com.unsa.services.academics.laboratories.domain.models.Enrollment;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EnrollmentPersistencePort {
    Mono<Enrollment> saveOneEnrollment(Enrollment enrollment);
    Flux<Enrollment> getAllEnrollments();
    Mono<Enrollment> getOneEnrollmentById(Long id);
    Mono<Void> updateOneEnrollment(Long id, Enrollment enrollment);
    Mono<Void> deleteOneEnrollment(Long id);
}
