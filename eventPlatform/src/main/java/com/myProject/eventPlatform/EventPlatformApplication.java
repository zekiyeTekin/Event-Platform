package com.myProject.eventPlatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
public class EventPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventPlatformApplication.class, args);
	}

}
