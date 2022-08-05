package com.lxc.springcloud.service;


import com.lxc.springcloud.entities.CommonResult;


public interface HystrixPaymentService{

    CommonResult paymentInfoTimeoutHandler();
}
