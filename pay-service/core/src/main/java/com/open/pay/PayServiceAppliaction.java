package com.open.pay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.client.RestTemplate;

/**
 *
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.open"})
@MapperScan(basePackages={"com.open.pay.dal.mapper"})
@EnableDiscoveryClient
@EnableKafka
public class PayServiceAppliaction {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	   // Do any additional configuration here
	   return builder.build();
	}
	
    public static void main(String[] args) {
        SpringApplication.run(PayServiceAppliaction.class, args);
    }
}
