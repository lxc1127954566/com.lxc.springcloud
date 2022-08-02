package com.lxc.springcloud.controller;


import com.lxc.springcloud.entities.CommonResult;
import com.lxc.springcloud.entities.Payment;
import com.lxc.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("payment")
public class PaymentController {

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
}
