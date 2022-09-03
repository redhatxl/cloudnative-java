package com.xuel.springbootgatewayserviceprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.xuel")
public class SpringbootGatewayServiceproviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootGatewayServiceproviderApplication.class, args);
    }

}
