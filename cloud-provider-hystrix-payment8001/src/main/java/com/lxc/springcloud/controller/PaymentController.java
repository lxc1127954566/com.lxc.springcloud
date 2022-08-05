package com.lxc.springcloud.controller;


import com.lxc.springcloud.entities.CommonResult;
import com.lxc.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {

    int count = 0;

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "hystrix/paymentInfoOK/{id}")
    public CommonResult paymentInfoOK(@PathVariable("id") Long id){
        return paymentService.paymentInfoOK(id);
    }

    @GetMapping(value = "hystrix/paymentInfoTimeout/{id}")
    public CommonResult paymentInfoTimeout(@PathVariable("id") Long id){

        log.info("************" + count++);
        return paymentService.paymentInfoTimeout(id);
    }
}
