package com.cse260.lease.web.app.service;

import com.cse260.lease.model.entity.PaymentType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @Author cse
* @description 针对表【payment_type(支付方式表)】的数据库操作Service
* @createDate 2024-06-26 11:12:39
*/
public interface PaymentTypeService extends IService<PaymentType> {
    List<PaymentType> listByRoomId(Long id);
}
