package com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.routes;

import com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.handlers.EnrollmentHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class EnrollmentRoutes {
    public static final String PATH = "/api/v1/enrollments";
    @Bean
    RouterFunction<ServerResponse> enrollmentRouter(EnrollmentHandler enrollmentHandler) {
        return RouterFunctions.route()
            .GET(PATH, enrollmentHandler::getAll)
            .GET(PATH + "/{enrollmentId}", enrollmentHandler::getById)
            .POST(PATH, enrollmentHandler::createOne)
            .PATCH(PATH + "/{enrollmentId}", enrollmentHandler::updateOne)
            .DELETE(PATH + "/{enrollmentId}", enrollmentHandler::deleteOne)
            .build();
    }
}
