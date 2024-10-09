package com.unsa.services.academics.laboratories.application.services;

import com.unsa.services.academics.laboratories.application.ports.in.EnrollmentServicePort;
import com.unsa.services.academics.laboratories.application.ports.out.EnrollmentPersistencePort;
import com.unsa.services.academics.laboratories.domain.models.Enrollment;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EnrollmentService implements EnrollmentServicePort {
    private final EnrollmentPersistencePort enrollmentPersistencePort;
    public EnrollmentService(EnrollmentPersistencePort persistencePort) {
        this.enrollmentPersistencePort = persistencePort;
    }
    @Override
    public Mono<Enrollment> createOneEnrollment(Enrollment enrollment) {
        return this.enrollmentPersistencePort.saveOneEnrollment(enrollment);
    }
    @Override
    public Flux<Enrollment> getAllEnrollments() {
        return this.enrollmentPersistencePort.getAllEnrollments();
    }
    @Override
    public Mono<Enrollment> getOneEnrollmentById(Long id) {
        return this.enrollmentPersistencePort.getOneEnrollmentById(id);
    }
    @Override
    public Mono<Void> updateOneEnrollment(Long id, Enrollment enrollment) {
        return this.enrollmentPersistencePort.updateOneEnrollment(id, enrollment);
    }
    @Override
    public Mono<Void> deleteOneEnrollment(Long id) {
        return this.enrollmentPersistencePort.deleteOneEnrollment(id);
    }
}
