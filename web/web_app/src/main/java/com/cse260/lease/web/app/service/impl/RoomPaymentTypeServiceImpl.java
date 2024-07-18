package com.cse260.lease.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cse260.lease.model.entity.RoomPaymentType;
import com.cse260.lease.web.app.service.RoomPaymentTypeService;
import com.cse260.lease.web.app.mapper.RoomPaymentTypeMapper;
import org.springframework.stereotype.Service;

/**
* @Author cse
* @description 针对表【room_payment_type(房间&支付方式关联表)】的数据库操作Service实现
* @createDate 2024-06-26 11:12:39
*/
@Service
public class RoomPaymentTypeServiceImpl extends ServiceImpl<RoomPaymentTypeMapper, RoomPaymentType>
    implements RoomPaymentTypeService{

}




