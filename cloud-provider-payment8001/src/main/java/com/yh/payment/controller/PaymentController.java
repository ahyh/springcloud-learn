package com.yh.payment.controller;

import com.yh.cloud.commons.pojo.CommonResult;
import com.yh.cloud.commons.pojo.Payment;
import com.yh.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping(value = "/payment/save")
    public CommonResult insert(@RequestBody Payment payment) {
        int insert = paymentService.insert(payment);
        log.info("insert result: {}", insert);
        if (insert > 0) {
            return new CommonResult(200, "insert success");
        } else {
            return new CommonResult(500, "insert failed");
        }
    }

    @GetMapping(value = "/payment{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("payment:{}", payment);
        if (payment != null) {
            return new CommonResult(200, "success", payment);
        } else {
            return new CommonResult(500, "search failed");
        }
    }

}
