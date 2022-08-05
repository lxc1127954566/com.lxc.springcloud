package com.lxc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient          //该注解用于想consul或zookeeper作为注册中心时注册服务
public class ProviderPayment8003Main {

    public static void main(String[] args) {
        SpringApplication.run(ProviderPayment8003Main.class,args);
    }
}
