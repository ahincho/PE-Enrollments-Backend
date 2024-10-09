package com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.routes;

import com.unsa.services.academics.laboratories.infrastructure.adapters.in.web.handlers.CourseHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class CourseRoutes {
    public static final String PATH = "/api/v1/courses";
    @Bean
    RouterFunction<ServerResponse> courseRouter(CourseHandler courseHandler) {
        return RouterFunctions.route()
            .GET(PATH, courseHandler::getAll)
            .GET(PATH + "/{courseId}", courseHandler::getById)
            .POST(PATH, courseHandler::createOne)
            .PATCH(PATH + "/{courseId}", courseHandler::updateOne)
            .DELETE(PATH + "/{courseId}", courseHandler::deleteOne)
            .build();
    }
}
