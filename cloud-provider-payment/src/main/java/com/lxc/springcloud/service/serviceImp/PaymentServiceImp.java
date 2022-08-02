package com.lxc.springcloud.service.serviceImp;

import com.lxc.springcloud.dao.PaymentDao;
import com.lxc.springcloud.entities.CommonResult;
import com.lxc.springcloud.entities.Payment;
import com.lxc.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentServiceImp implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public CommonResult create(Payment payment) {
        int result = paymentDao.insert(payment);
        log.info("**********插入数据结果："+result);
        if ( result > 0) {
            return new CommonResult(200,"账单插入成功");
        }
        return new CommonResult(400,"数据有误插入失败");
    }

    @Override
    public CommonResult getPaymentById(Long id) {
        Payment payment = paymentDao.selectById(id);
        log.info("**********查询数据结果："+payment);
        if (payment != null) {
            return new CommonResult(200, "查找到数据", payment);
        }
        return new CommonResult(400,"未查找到数据");
    }
}
