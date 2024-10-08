package com.unsa.services.academics.laboratories.infrastructure.adapters.in.web;

import com.unsa.services.academics.laboratories.application.services.EnrollmentService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/enrollments")
public class EnrollmentsRestController {
    private final EnrollmentService enrollmentService;
    public EnrollmentsRestController(final EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }
}
