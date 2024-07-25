package com.cse260.lease.web.app.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cse260.lease.common.login.LoginUserHolder.LoginUserHolder;
import com.cse260.lease.model.entity.Coupon;
import com.cse260.lease.model.entity.UserCoupon;
import com.cse260.lease.model.enums.CouponStatus;
import com.cse260.lease.model.enums.UserCouponStatus;
import com.cse260.lease.web.app.mapper.CouponMapper;
import com.cse260.lease.web.app.service.CouponService;
import com.cse260.lease.web.app.service.UserCouponService;
import com.cse260.lease.web.app.vo.coupon.CouponVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class CouponServiceImpl extends ServiceImpl<CouponMapper, Coupon> implements CouponService {



    @Autowired
    private UserCouponService userCouponService;
    @Override
    public List<CouponVo> listItem() {

        // 获取当前登录用户
        Long userId = LoginUserHolder.getLoginUser().getUserId();


        // 获取发放中的优惠券id列表
        LambdaQueryWrapper<Coupon> queryWrapper_issuing = new LambdaQueryWrapper<Coupon>();
        queryWrapper_issuing.in(Coupon::getStatus, CouponStatus.ISSUING);
        List<Coupon> coupons_issuing=this.list(queryWrapper_issuing);
        Set<Long> couponIds = coupons_issuing.stream().map(Coupon::getId).collect(Collectors.toSet());
        List<CouponVo> couponVOS = new ArrayList<>();

        if(!couponIds.isEmpty()){
            // 查询user_coupon表，条件：当前用户user_id、发放中的优惠券id列表
            List<UserCoupon> userCoupons = userCouponService.lambdaQuery().eq(UserCoupon::getUserId, userId)
                    .in(UserCoupon::getCouponId, couponIds)
                    .list();

            // 统计当前用户针对每个券的已领取数量，即<couponId,allCount>
            Map<Long, Long> issueMap = userCoupons.stream()
                    .collect(Collectors.groupingBy(UserCoupon::getCouponId, Collectors.counting()));

            // 统计当前用户针对每个券的已领取且未使用数量,即<couponId,unUsedCount>
            Map<Long, Long> unUsedMap = userCoupons.stream()
                    .filter(userCoupon -> userCoupon.getStatus().equals(UserCouponStatus.UNUSED))
                    .collect(Collectors.groupingBy(UserCoupon::getCouponId, Collectors.counting()));

            // entity转vo
            for (Coupon coupon : coupons_issuing) {
                CouponVo couponVo =new CouponVo();
                BeanUtils.copyProperties(coupon,couponVo);

                // 优惠券还有剩余(已发放数量issueNum < 总发放数量totalNum)且用户领取数量(统计user_coupon表)小于该优惠券领取上限user_limit
                boolean available = coupon.getIssueNum() < coupon.getTotalNum()
                        && issueMap.getOrDefault(coupon.getId(), 0L) < coupon.getUserLimit();
                couponVo.setAvailable(available);    // 是否可以领取

                // 统计user_coupon表，查询当前用户已经领取且未使用的券数量是否大于0
                boolean received = unUsedMap.getOrDefault(coupon.getId(), 0L) > 0;
                couponVo.setReceived(received); // 是否可以使用
                couponVOS.add(couponVo);
            }
        }


        // 获取未开始的优惠券id列表
        LambdaQueryWrapper<Coupon> queryWrapper_unissue = new LambdaQueryWrapper<Coupon>();
        queryWrapper_unissue.in(Coupon::getStatus, CouponStatus.UN_ISSUE);
        List<Coupon> coupons_unissue=this.list(queryWrapper_unissue);
        //entity转Vo
        for(Coupon coupon:coupons_unissue){
            CouponVo couponVo =new CouponVo();
            BeanUtils.copyProperties(coupon,couponVo);

            boolean available = coupon.getIssueNum() < coupon.getTotalNum();
            couponVo.setAvailable(available);    // 是否可以领取

            boolean received = false;
            couponVo.setReceived(received); // 是否可以使用
            couponVOS.add(couponVo);
        }

        return couponVOS;
    }



}
