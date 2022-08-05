package com.lxc.springcloud.service.serviceImp;

import com.lxc.springcloud.entities.CommonResult;
import com.lxc.springcloud.service.HystrixPaymentService;
import com.lxc.springcloud.service.HystrixService;

public class HystrixPaymentServiceImp implements HystrixPaymentService {


    @Override
    public CommonResult paymentInfoTimeoutHandler() {
        return null;
    }
}
