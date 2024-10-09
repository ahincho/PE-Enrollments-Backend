package com.unsa.services.academics.laboratories.infrastructure.adapters.out.persistence;

import com.unsa.services.academics.laboratories.application.ports.out.LaboratoryPersistencePort;
import com.unsa.services.academics.laboratories.domain.models.Laboratory;
import com.unsa.services.academics.laboratories.infrastructure.adapters.out.persistence.mappers.LaboratoryR2dbcMapper;
import com.unsa.services.academics.laboratories.infrastructure.adapters.out.persistence.repositories.LaboratoryR2dbcRepository;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LaboratoryPersistenceSqlAdapter implements LaboratoryPersistencePort {
    private final LaboratoryR2dbcRepository laboratoryR2dbcRepository;
    public LaboratoryPersistenceSqlAdapter(LaboratoryR2dbcRepository laboratoryR2dbcRepository) {
        this.laboratoryR2dbcRepository = laboratoryR2dbcRepository;
    }
    @Override
    public Mono<Laboratory> saveOneLaboratory(Laboratory laboratory) {
        return this.laboratoryR2dbcRepository
            .save(LaboratoryR2dbcMapper.toEntity(laboratory))
            .map(LaboratoryR2dbcMapper::toDomain);
    }
    @Override
    public Flux<Laboratory> getAllLaboratories() {
        return this.laboratoryR2dbcRepository
            .findAll()
            .map(LaboratoryR2dbcMapper::toDomain);
    }
    @Override
    public Mono<Laboratory> getOneLaboratoryById(Long id) {
        return this.laboratoryR2dbcRepository
            .findById(id)
            .map(LaboratoryR2dbcMapper::toDomain);
    }
    @Override
    public Mono<Void> updateOneLaboratory(Long id, Laboratory laboratory) {
        return null;
    }
    @Override
    public Mono<Void> deleteOneLaboratory(Long id) {
        return this.laboratoryR2dbcRepository.deleteById(id);
    }
}
