package com.example.ApiGatewayApp;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {
    @Bean
    public RouteLocator myRoute(RouteLocatorBuilder builder)
    {
        return builder.routes()
                .route(p->p
                        .path("api/user/v1/**")
                        .uri("http://localhost:8086/"))
                .route(p->p.path("api/product/v1/**")
                        .uri("http://localhost:8080/"))
                .build();
    }
}
