package com.unsa.services.academics.laboratories.application.ports.out;

import com.unsa.services.academics.laboratories.domain.models.Laboratory;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LaboratoryPersistencePort {
    Mono<Laboratory> saveOneLaboratory(Laboratory laboratory);
    Flux<Laboratory> getAllLaboratories();
    Mono<Laboratory> getOneLaboratoryById(Long id);
    Mono<Void> updateOneLaboratory(Long id, Laboratory laboratory);
    Mono<Void> deleteOneLaboratory(Long id);
}
