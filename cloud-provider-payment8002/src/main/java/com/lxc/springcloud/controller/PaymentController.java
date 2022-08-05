package com.lxc.springcloud.controller;


import com.lxc.springcloud.entities.CommonResult;
import com.lxc.springcloud.entities.Payment;
import com.lxc.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private PaymentService paymentService;

    @PostMapping("create")
    public CommonResult addPayment(@RequestBody Payment payment){
        return paymentService.create(payment);
    }

    @GetMapping("getById/{id}")
    public CommonResult getById(@PathVariable("id") Long id ){
        return paymentService.getPaymentById(id);
    }

    @GetMapping("discovery")
    public CommonResult discovery(){
        return paymentService.discovery();
    }

    @GetMapping("getPort")
    public String getPort() {
        return serverPort;
    }
}
