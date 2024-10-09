package com.unsa.services.academics.laboratories.application.services;

import com.unsa.services.academics.laboratories.application.ports.in.LaboratoryServicePort;
import com.unsa.services.academics.laboratories.application.ports.out.LaboratoryPersistencePort;
import com.unsa.services.academics.laboratories.domain.models.Laboratory;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LaboratoryService implements LaboratoryServicePort {
    private final LaboratoryPersistencePort laboratoryPersistencePort;
    public LaboratoryService(LaboratoryPersistencePort laboratoryPersistencePort) {
        this.laboratoryPersistencePort = laboratoryPersistencePort;
    }
    @Override
    public Mono<Laboratory> createOneLaboratory(Laboratory laboratory) {
        return this.laboratoryPersistencePort.saveOneLaboratory(laboratory);
    }
    @Override
    public Flux<Laboratory> getAllLaboratories() {
        return this.laboratoryPersistencePort.getAllLaboratories();
    }
    @Override
    public Mono<Laboratory> getOneLaboratoryById(Long id) {
        return this.laboratoryPersistencePort.getOneLaboratoryById(id);
    }
    @Override
    public Mono<Void> updateOneLaboratory(Long id, Laboratory laboratory) {
        return this.laboratoryPersistencePort.updateOneLaboratory(id, laboratory);
    }
    @Override
    public Mono<Void> deleteOneLaboratory(Long id) {
        return this.laboratoryPersistencePort.deleteOneLaboratory(id);
    }
}
