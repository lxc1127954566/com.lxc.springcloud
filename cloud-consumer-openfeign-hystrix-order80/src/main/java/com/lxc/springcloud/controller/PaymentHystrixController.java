package com.lxc.springcloud.controller;


import com.lxc.springcloud.entities.CommonResult;
import com.lxc.springcloud.service.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("consumer")
public class PaymentHystrixController {

    @Autowired
    private HystrixService hystrixService;

    @GetMapping(value = "paymentInfoOK/{id}")
    public CommonResult infoOK(@PathVariable("id") Long id){
        return hystrixService.paymentInfoOK(id);
    }

    @GetMapping(value = "paymentInfoTimeout/{id}")
    public CommonResult infoTimeout(@PathVariable("id") Long id){
        return hystrixService.paymentInfoTimeout(id);
    }
}
