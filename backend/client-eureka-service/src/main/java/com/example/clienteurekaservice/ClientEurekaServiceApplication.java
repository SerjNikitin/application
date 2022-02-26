package com.example.clienteurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@RefreshScope
//@LoadBalancerClient
@EnableEurekaClient
@SpringBootApplication
public class ClientEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientEurekaServiceApplication.class, args);
	}

}
