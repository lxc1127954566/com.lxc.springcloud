package com.lxc.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class ProviderPaymentHystrix8001Main {

    public static void main(String[] args) {
        SpringApplication.run(ProviderPaymentHystrix8001Main.class, args);
    }
}
