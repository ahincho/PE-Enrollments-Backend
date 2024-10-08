package com.unsa.services.academics.laboratories.application.ports.in;

import com.unsa.services.academics.laboratories.domain.models.Laboratory;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LaboratoryServicePort {
    Mono<Laboratory> createOneLaboratory(Laboratory laboratory);
    Flux<Laboratory> getAllLaboratories();
    Mono<Laboratory> getOneLaboratoryById(Long id);
    Mono<Void> updateOneLaboratory(Long id, Laboratory laboratory);
    Mono<Void> deleteOneLaboratory(Long id);
}
