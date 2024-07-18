package com.cse260.lease.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cse260.lease.model.entity.ApartmentFeeValue;
import com.cse260.lease.web.app.service.ApartmentFeeValueService;
import com.cse260.lease.web.app.mapper.ApartmentFeeValueMapper;
import org.springframework.stereotype.Service;

/**
* @Author cse
* @description 针对表【apartment_fee_value(公寓&杂费关联表)】的数据库操作Service实现
* @createDate 2024-06-26 11:12:39
*/
@Service
public class ApartmentFeeValueServiceImpl extends ServiceImpl<ApartmentFeeValueMapper, ApartmentFeeValue>
    implements ApartmentFeeValueService{
}




