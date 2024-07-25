package com.cse260.lease.web.app.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cse260.lease.model.entity.Coupon;
import com.cse260.lease.web.app.vo.coupon.CouponVo;

import java.util.List;

/**
 * @Author cse
 * @description 针对表【coupon】的数据库操作Service
 * @createDate 2024-07-18 15:48:00
 */
public interface CouponService extends IService<Coupon> {


    List<CouponVo> listItem();
}
