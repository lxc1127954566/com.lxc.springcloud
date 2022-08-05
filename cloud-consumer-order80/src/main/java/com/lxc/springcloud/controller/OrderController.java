package com.lxc.springcloud.controller;


import com.lxc.springcloud.entities.CommonResult;
import com.lxc.springcloud.entities.Payment;
import com.lxc.springcloud.lb.LoadBalancer;
import com.netflix.loadbalancer.ILoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("consumer")
public class OrderController {

    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalancer loadBalancer;

    @GetMapping(value = "payment/create")
    public CommonResult create(Payment payment){
        log.info("***********远程调用create");
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping(value = "payment/getById/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id ){
        log.info("***********远程调用getById");
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getById/"+id,CommonResult.class);
    }

    @GetMapping(value = "payment/getByIdEntity/{id}")
    public CommonResult<Payment> getPayment1(@PathVariable("id") Long id ){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL+"/payment/getById/"+id,CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            log.info("header :" + entity.getHeaders());
            return entity.getBody();
        }else {
            return new CommonResult(444,"失败");
        }
    }

    @GetMapping(value = "getPort")
    public String getPort(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0 ){
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instance(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/getPort",String.class);
    }
}
