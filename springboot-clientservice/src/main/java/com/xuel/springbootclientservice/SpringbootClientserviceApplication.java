package com.xuel.springbootclientservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.xuel")
@EnableFeignClients("com.xuel")
public class SpringbootClientserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootClientserviceApplication.class, args);
	}

}
