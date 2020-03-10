package com.yh.payment.test.service;

import com.yh.cloud.commons.pojo.Payment;
import com.yh.payment.service.PaymentService;
import com.yh.payment.test.ApplicationTest;
import org.junit.Test;

import javax.annotation.Resource;

public class PaymentServiceTest extends ApplicationTest {

    @Resource
    private PaymentService paymentService;

    @Test
    public void testInsert(){
        Payment payment = new Payment(1L,"abcd");
        paymentService.insert(payment);
    }
}
