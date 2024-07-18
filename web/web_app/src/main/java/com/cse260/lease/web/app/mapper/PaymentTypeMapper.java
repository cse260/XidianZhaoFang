package com.cse260.lease.web.app.mapper;

import com.cse260.lease.model.entity.PaymentType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @Author cse
* @description 针对表【payment_type(支付方式表)】的数据库操作Mapper
* @createDate 2024-06-26 11:12:39
* @Entity com.cse260.lease.model.entity.PaymentType
*/
public interface PaymentTypeMapper extends BaseMapper<PaymentType> {

    List<PaymentType> selectListByRoomId(Long id);
}




