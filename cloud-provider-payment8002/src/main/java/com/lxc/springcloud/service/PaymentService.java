package com.lxc.springcloud.service;

import com.lxc.springcloud.entities.CommonResult;
import com.lxc.springcloud.entities.Payment;

public interface PaymentService {

    CommonResult create(Payment payment);

    CommonResult getPaymentById(Long id);

    CommonResult discovery();
}
