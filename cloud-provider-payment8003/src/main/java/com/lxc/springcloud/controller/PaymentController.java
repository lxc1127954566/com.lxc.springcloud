package com.lxc.springcloud.controller;


import com.lxc.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "zk")
    public CommonResult payment(){
        return new CommonResult(200,"执行成功","Springcloud with zookeeper: " + serverPort + "\t" + UUID.randomUUID().toString());
    }
}
