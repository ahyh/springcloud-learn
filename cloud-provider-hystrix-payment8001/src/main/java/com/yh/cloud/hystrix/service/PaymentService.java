package com.yh.cloud.hystrix.service;

public interface PaymentService {

    String getInfoSuccess(Integer id);

    String getInfoFailure(Integer id);

    String paymentCircuitBreaker(Integer id);
}
