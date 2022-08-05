package com.lxc.springcloud.service;

import com.lxc.springcloud.entities.CommonResult;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component(value = "HystrixService")
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE")
public interface HystrixService {

    @GetMapping(value = "payment/hystrix/paymentInfoOK/{id}")
    CommonResult paymentInfoOK(@PathVariable("id") Long id);

    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    @GetMapping(value = "payment/hystrix/paymentInfoTimeout/{id}")
    CommonResult paymentInfoTimeout(@PathVariable("id") Long id);

    CommonResult paymentInfoTimeoutHandler();
}
