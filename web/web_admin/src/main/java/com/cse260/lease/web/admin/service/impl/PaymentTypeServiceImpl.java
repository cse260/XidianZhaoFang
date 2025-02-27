package com.cse260.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cse260.lease.model.entity.PaymentType;
import com.cse260.lease.web.admin.service.PaymentTypeService;
import com.cse260.lease.web.admin.mapper.PaymentTypeMapper;
import org.springframework.stereotype.Service;

/**
* @Author cse
* @description 针对表【payment_type(支付方式表)】的数据库操作Service实现
* @createDate 2024-06-24 15:48:00
*/
@Service
public class PaymentTypeServiceImpl extends ServiceImpl<PaymentTypeMapper, PaymentType>
    implements PaymentTypeService{

}




