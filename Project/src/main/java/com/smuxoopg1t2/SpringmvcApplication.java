package com.smuxoopg1t2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @SpringBootApplication -  marks the main class of a Spring Boot application.
 * This is used usually on a configuration class that declares one or more @Bean methods and also triggers
 * auto-configuration and component scanning.
 * The @SpringBootApplication annotation is equivalent to using @Configuration, @EnableAutoConfiguration,
 * and @ComponentScan with their default attributes.
 *
 * @EnableScheduling - With this annotation, we can enable scheduling in the application.
 * As a result, we can now run methods periodically with @Scheduled.
 */
@SpringBootApplication
@EnableScheduling
public class SpringmvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcApplication.class, args);
	}
	
}
