package com.cse260.lease.web.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cse260.lease.model.entity.UserCoupon;
import com.cse260.lease.model.enums.CouponStatus;
import com.cse260.lease.web.app.dto.coupon.UserCouponDTO;
import com.cse260.lease.web.app.vo.coupon.CouponUserPageVo;

/**
* @author cse
* @description 针对表【user_coupon(用户领取优惠券的记录，是真正使用的优惠券信息)】的数据库操作Service
* @createDate 2024-07-19 15:16:18
*/
public interface UserCouponService extends IService<UserCoupon> {

    IPage<CouponUserPageVo> pageItemByUserId(Page<CouponUserPageVo> page, Long userId, CouponStatus status);

    void receiveCoupon(Long id);


    void createUserCoupon(UserCouponDTO msg);
}
