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

	@Value("${test.uri:http://127.0.0.1:2222/user/select}")
	String uri;


	@Bean
	public RouterFunction<ServerResponse> testFunRouterFunction() {
		RouterFunction<ServerResponse> route = RouterFunctions.route(
				RequestPredicates.path("/testfun"),
				request -> ServerResponse.ok().body(BodyInserters.fromObject("hello")));
		return route;
	}

	static class Hello {
		String message;

		public Hello() { }

		public Hello(String message) {
			this.message = message;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}
	
    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceAppliaction.class, args);
    }
}
