package com.unsa.services.academics.laboratories.infrastructure.adapters.out.persistence;

import com.unsa.services.academics.laboratories.application.ports.out.EnrollmentPersistencePort;
import com.unsa.services.academics.laboratories.domain.models.Enrollment;

import com.unsa.services.academics.laboratories.infrastructure.adapters.out.persistence.mappers.EnrollmentR2dbcMapper;
import com.unsa.services.academics.laboratories.infrastructure.adapters.out.persistence.repositories.EnrollmentR2dbcRepository;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EnrollmentPersistenceSqlAdapter implements EnrollmentPersistencePort {
    private final EnrollmentR2dbcRepository enrollmentR2dbcRepository;
    public EnrollmentPersistenceSqlAdapter(EnrollmentR2dbcRepository enrollmentR2dbcRepository) {
        this.enrollmentR2dbcRepository = enrollmentR2dbcRepository;
    }
    @Override
    public Mono<Enrollment> saveOneEnrollment(Enrollment enrollment) {
        return this.enrollmentR2dbcRepository
            .save(EnrollmentR2dbcMapper.toEntity(enrollment))
            .map(EnrollmentR2dbcMapper::toDomain);
    }
    @Override
    public Flux<Enrollment> getAllEnrollments() {
        return this.enrollmentR2dbcRepository
            .findAll()
            .map(EnrollmentR2dbcMapper::toDomain);
    }
    @Override
    public Mono<Enrollment> getOneEnrollmentById(Long id) {
        return this.enrollmentR2dbcRepository
            .findById(id)
            .map(EnrollmentR2dbcMapper::toDomain);
    }
    @Override
    public Mono<Void> updateOneEnrollment(Long id, Enrollment enrollment) {
        return null;
    }
    @Override
    public Mono<Void> deleteOneEnrollment(Long id) {
        return this.enrollmentR2dbcRepository.deleteById(id);
    }
}
