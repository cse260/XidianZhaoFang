package com.cse260.lease.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cse260.lease.model.entity.Coupon;

/**
* @author cse
* @description 针对表【coupon(优惠券的规则信息)】的数据库操作Mapper
* @createDate 2024-07-18 21:20:56
* @Entity com.cse260.lease.entity.Coupon
*/
public interface CouponMapper extends BaseMapper<Coupon> {

    int increaseIssueNum(Long id);
}




