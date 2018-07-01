package com.open.gateway;

import com.open.gateway.filter.ThrottleGatewayFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 *
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.open"})
@EnableDiscoveryClient
//@Import(AdditionalRoutes.class)
public class GatewayServiceAppliaction {


    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                //basic proxy
                .route(r -> r.path("/baidu")
                        .uri("http://127.0.0.1:3333/auth/require").order(1)
                ).build();
    }
	
    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceAppliaction.class, args);
    }
}
