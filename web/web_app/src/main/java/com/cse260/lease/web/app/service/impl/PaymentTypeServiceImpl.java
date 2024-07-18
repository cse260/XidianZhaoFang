package com.cse260.lease.web.app.service.impl;

import com.cse260.lease.model.entity.PaymentType;
import com.cse260.lease.web.app.mapper.PaymentTypeMapper;
import com.cse260.lease.web.app.service.PaymentTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @Author cse
* @description 针对表【payment_type(支付方式表)】的数据库操作Service实现
* @createDate 2024-06-26 11:12:39
*/
@Service
public class PaymentTypeServiceImpl extends ServiceImpl<PaymentTypeMapper, PaymentType>
    implements PaymentTypeService{

    @Autowired
    private PaymentTypeMapper paymentTypeMapper;
    @Override
    public List<PaymentType> listByRoomId(Long id) {
        return paymentTypeMapper.selectListByRoomId(id);    }
}




