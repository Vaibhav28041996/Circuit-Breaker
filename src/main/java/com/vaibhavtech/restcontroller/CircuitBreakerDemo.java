package com.vaibhavtech.restcontroller;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
/**
 * 
 * @author Vaibhav
 *
 */
@RestController
public class CircuitBreakerDemo extends RuntimeException {
	private static final long serialVersionUID = 1L;

	@GetMapping(value = { "/getdata" })
	/**
	 * 
	 * Hystrix Property Added
	 */
	@HystrixCommand(
			fallbackMethod = "getDataFromDB",
			commandProperties = {
					@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "5"),
					@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
					@HystrixProperty(name = "circuitBreaker.enabled",value = "true")
			}
			)
	public String getDataFromRedisCache() {
		System.out.println("**getDataFromRedisCache() method called**");
		if (new Random().nextInt(10) <= 10) {
			throw new RuntimeException("Redis server is down");
		}
		return "Data accessed from redis cache";
	}

	public String getDataFromDB() {
		System.out.println("**getDataFromDB() method called**");
		return "Data accessed from Db";

	}
}
