package com.unsa.services.academics.users.infrastructure.adapters.in.web.routes;

import com.unsa.services.academics.users.infrastructure.adapters.in.web.handlers.UserHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class UserRoutes {
    public static final String PATH = "/api/v1/users";
    @Bean
    RouterFunction<ServerResponse> userRouter(UserHandler userHandler) {
        return RouterFunctions.route()
            .GET(PATH, userHandler::getAll)
            .GET(PATH + "/{userId}", userHandler::getById)
            .POST(PATH, userHandler::createOne)
            .PATCH(PATH + "/{userId}", userHandler::updateOne)
            .DELETE(PATH + "/{userId}", userHandler::deleteOne)
            .build();
    }
}
