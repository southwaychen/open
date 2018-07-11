package com.open.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

/**
 *
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.open"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.open"})
public class AuthServiceAppliaction {
	
    public static void main(String[] args) {
        SpringApplication.run(AuthServiceAppliaction.class, args);
    }
}
