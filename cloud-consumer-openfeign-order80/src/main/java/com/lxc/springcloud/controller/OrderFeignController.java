package com.lxc.springcloud.controller;


import com.lxc.springcloud.entities.CommonResult;
import com.lxc.springcloud.entities.Payment;
import com.lxc.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consumer")
public class OrderFeignController {

    @Autowired
    private PaymentFeignService feignService;

    @GetMapping(value = "getPaymentOk/{id}")
    public CommonResult<Payment> getPaymentOk(@PathVariable("id") Long id ){
        return feignService.getPayment(id);
    }

    @GetMapping(value = "getPaymentTimeout")
    public CommonResult getPaymentTimeout(){
        return feignService.timeout();
    }
}
