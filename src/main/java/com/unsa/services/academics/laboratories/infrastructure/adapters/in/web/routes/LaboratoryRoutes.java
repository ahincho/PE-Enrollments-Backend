package com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.routes;

import com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.handlers.LaboratoryHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class LaboratoryRoutes {
    public static final String PATH = "/api/v1/laboratories";
    @Bean
    RouterFunction<ServerResponse> laboratoryRouter(LaboratoryHandler laboratoryHandler) {
        return RouterFunctions.route()
            .GET(PATH, laboratoryHandler::getAll)
            .GET(PATH + "/{laboratoryId}", laboratoryHandler::getById)
            .POST(PATH, laboratoryHandler::createOne)
            .PATCH(PATH + "/{laboratoryId}", laboratoryHandler::updateOne)
            .DELETE(PATH + "/{laboratoryId}", laboratoryHandler::deleteOne)
            .build();
    }
}
