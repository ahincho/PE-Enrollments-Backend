package com.unsa.services.academics.laboratories.infrastructure.adapters.out.persistence;

import com.unsa.services.academics.laboratories.application.ports.out.LaboratoryPersistencePort;
import com.unsa.services.academics.laboratories.domain.models.Laboratory;
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
        return null;
    }
    @Override
    public Flux<Laboratory> getAllLaboratories() {
        return null;
    }
    @Override
    public Mono<Laboratory> getOneLaboratoryById(Long id) {
        return null;
    }
    @Override
    public Mono<Void> updateOneLaboratory(Long id, Laboratory laboratory) {
        return null;
    }
    @Override
    public Mono<Void> deleteOneLaboratory(Long id) {
        return null;
    }
}
