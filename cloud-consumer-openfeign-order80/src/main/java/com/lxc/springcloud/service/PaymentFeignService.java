package com.lxc.springcloud.service;

import com.lxc.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component(value = "PaymentFeignService")
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "payment/getById/{id}")
    CommonResult getPayment(@PathVariable("id") Long id );

    @GetMapping(value = "payment/timeout")
    CommonResult timeout();
}
