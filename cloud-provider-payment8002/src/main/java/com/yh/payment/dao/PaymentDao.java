package com.yh.payment.dao;

import com.yh.cloud.commons.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * DAO
 *
 * @author yanhuan
 */
@Mapper
public interface PaymentDao {

    int insert(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
