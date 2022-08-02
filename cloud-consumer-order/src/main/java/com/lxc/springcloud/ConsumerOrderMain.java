package com.lxc.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ConsumerOrderMain {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderMain.class, args);
    }
}
