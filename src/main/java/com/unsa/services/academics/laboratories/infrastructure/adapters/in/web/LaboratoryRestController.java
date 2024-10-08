package com.unsa.services.academics.laboratories.infrastructure.adapters.in.web;

import com.unsa.services.academics.laboratories.application.services.LaboratoryService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/laboratories")
public class LaboratoryRestController {
    private final LaboratoryService laboratoryService;
    public LaboratoryRestController(final LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }
}
