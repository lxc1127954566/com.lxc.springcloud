package com.lxc.springcloud.service;

import com.lxc.springcloud.entities.CommonResult;

public interface PaymentService {

    CommonResult paymentInfoOK(Long id);

    CommonResult paymentInfoTimeout(Long id);
}
