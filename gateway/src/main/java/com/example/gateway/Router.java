package com.example.gateway;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class Router {

    private final Filter filter;

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("bill", r -> r.path("/bs-api/**").uri("lb://bill-service"))
                .route("person", r -> r.path("/ps-api/**").uri("lb://person-service"))
                .route("client", r -> r.path("/client").uri("lb://eureka-client"))
                .build();
    }

}
