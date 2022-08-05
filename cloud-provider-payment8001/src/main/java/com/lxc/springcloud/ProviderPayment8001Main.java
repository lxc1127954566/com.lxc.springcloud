package com.lxc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderPayment8001Main {

    public static void main(String[] args) {
        SpringApplication.run(ProviderPayment8001Main.class,args);
    }
}
