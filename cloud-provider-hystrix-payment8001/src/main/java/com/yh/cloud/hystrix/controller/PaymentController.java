package com.yh.cloud.hystrix.controller;

import com.yh.cloud.hystrix.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Payment Controller
 *
 * @author yanhuan
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/payment/get/{id}")
    public String get(@PathVariable("id") Integer id) {
        String infoSuccess = paymentService.getInfoSuccess(id);
        return infoSuccess;
    }

    @GetMapping(value = "/payment/get/f/{id}")
    public String getF(@PathVariable("id") Integer id) {
        String infoFailure = paymentService.getInfoFailure(id);
        return infoFailure;
    }

    @GetMapping(value = "/payment/get/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentService.paymentCircuitBreaker(id);
        return result;
    }

}
