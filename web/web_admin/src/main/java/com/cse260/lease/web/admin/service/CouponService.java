package com.cse260.lease.web.admin.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cse260.lease.model.entity.Coupon;
import com.cse260.lease.web.admin.dto.coupon.CouponIssueFormDTO;
import com.cse260.lease.web.admin.vo.coupon.CouponDetailVo;
import com.cse260.lease.web.admin.vo.coupon.CouponPageVo;

/**
 * @Author cse
 * @description 针对表【coupon】的数据库操作Service
 * @createDate 2024-07-18 15:48:00
 */
public interface CouponService extends IService<Coupon> {


    IPage<CouponPageVo> pageCoupon(Page<CouponPageVo> page);

    CouponDetailVo selectCouponById(Long id);

    void issueCoupon(CouponIssueFormDTO dto);

    void pauseIssueCoupon(Long id);
}
