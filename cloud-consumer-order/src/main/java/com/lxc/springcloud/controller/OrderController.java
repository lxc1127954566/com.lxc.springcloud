package com.lxc.springcloud.controller;


import com.lxc.springcloud.entities.CommonResult;
import com.lxc.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("consumer")
public class OrderController {

    private static final String PAYMENT_URL = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/payment/create")
    public CommonResult create(Payment payment){
        log.info("***********远程调用create");
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping(value = "payment/getById/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id ){
        log.info("***********远程调用getById");
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getById/"+id,CommonResult.class);
    }
}
