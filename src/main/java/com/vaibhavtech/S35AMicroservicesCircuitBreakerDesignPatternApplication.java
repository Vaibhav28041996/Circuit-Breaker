package com.vaibhavtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
/**
 * 
 * @author Vaibhav
 * 
 */
@SpringBootApplication
/**
 * enabling hystrix circuit breaker
 */
@EnableHystrix
public class S35AMicroservicesCircuitBreakerDesignPatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(S35AMicroservicesCircuitBreakerDesignPatternApplication.class, args);
	}

}
