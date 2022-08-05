package com.lxc.springcloud.service.serviceImp;

import com.lxc.springcloud.entities.CommonResult;
import com.lxc.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


@Service
public class PaymentServiceImp implements PaymentService {

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    @Override
    public CommonResult<String> paymentInfoOK(Long id) {
        return new CommonResult("线程池： " + Thread.currentThread().getName() + "  paymentInfo_OK,id: " + id + "\t" + "嘿嘿");
    }


    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    @Override
    public CommonResult<String> paymentInfoTimeout(Long id) {
        Integer timeNumber = 5;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CommonResult("线程池： " + Thread.currentThread().getName() + "  paymentInfo_OK,id: " + id + "\t" + "嘿嘿,  耗时： " + timeNumber + " s");
    }

    public CommonResult<String> paymentInfo_TimeoutHandler(Long id) {
        return new CommonResult("线程池： " + Thread.currentThread().getName() + "  paymentInfo_OK,id: " + id + "\t" + ",   超时");
    }


}
