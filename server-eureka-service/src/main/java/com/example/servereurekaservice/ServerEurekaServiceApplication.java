package com.example.servereurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServerEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerEurekaServiceApplication.class, args);
	}

}
