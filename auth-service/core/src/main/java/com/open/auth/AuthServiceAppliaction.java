package com.open.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

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
