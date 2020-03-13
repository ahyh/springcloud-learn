package com.yh.payment.service;


import com.yh.cloud.commons.pojo.Payment;

public interface PaymentService {

    int insert(Payment payment);

    Payment getPaymentById(Long id);
}
