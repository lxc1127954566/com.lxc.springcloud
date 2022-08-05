package com.lxc.springcloud.controller;


import com.lxc.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consumerzk")
public class OrderZKController {

    private static final String PAYMENT_URL = "http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "payment/zk")
    public CommonResult paymentInfo(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/zk/",CommonResult.class);
    }
}
