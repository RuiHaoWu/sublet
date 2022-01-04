package com.wrh.sublet.gateway.router;

import com.wrh.sublet.gateway.handler.ValidateCodeHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author DM
 */
@Configuration
public class ValidateCodeRouter {

    @Bean
    public RouterFunction<ServerResponse> routeFunction(ValidateCodeHandler validateCodeHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/code")
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), validateCodeHandler);
    }
}
