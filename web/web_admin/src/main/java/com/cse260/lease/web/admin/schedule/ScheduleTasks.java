package com.cse260.lease.web.admin.schedule;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.cse260.lease.common.constant.RedisConstant;
import com.cse260.lease.model.entity.Coupon;
import com.cse260.lease.model.entity.LeaseAgreement;
import com.cse260.lease.model.enums.CouponStatus;
import com.cse260.lease.model.enums.LeaseStatus;
import com.cse260.lease.web.admin.service.CouponService;
import com.cse260.lease.web.admin.service.LeaseAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class ScheduleTasks {
//    @Scheduled(cron="* * * * * *")
//    public void test(){
//        System.out.println(new Date());
//    }

    @Autowired
    private LeaseAgreementService leaseAgreementService;

    @Autowired
    private CouponService couponService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Scheduled(cron="0 0 0 * * *")
    public void checkLeaseStatus(){
        LambdaUpdateWrapper<LeaseAgreement> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.le(LeaseAgreement::getLeaseEndDate,new Date());
        updateWrapper.in(LeaseAgreement::getStatus,LeaseStatus.WITHDRAWING,LeaseStatus.SIGNED);
        updateWrapper.set(LeaseAgreement::getStatus, LeaseStatus.EXPIRED);
        leaseAgreementService.update(updateWrapper);
    }


    @Scheduled(cron ="0 * * * * *")
    public void checkIssueCouponStatus(){
        //先获取需要更新的优惠券id
        LambdaQueryWrapper<Coupon> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.le(Coupon::getIssueBeginTime,new Date());
        queryWrapper.in(Coupon::getStatus, CouponStatus.UN_ISSUE);
        List<Coupon> list = couponService.list(queryWrapper);

        //没有需要更新的优惠券
        if(list.isEmpty())
            return;
        //更新优惠券状态
        LambdaUpdateWrapper<Coupon> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.le(Coupon::getIssueBeginTime,new Date());
        updateWrapper.in(Coupon::getStatus, CouponStatus.UN_ISSUE);
        updateWrapper.set(Coupon::getStatus, CouponStatus.ISSUING);
        couponService.update(updateWrapper);

        //将需要更新的优惠券加入redis中
        for(Coupon coupon:list){
            String key = RedisConstant.COUPON_CACHE_KEY_PREFIX + coupon.getId();   // 拼接key
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
            // 开始领取时间，转成Long方便比较
            redisTemplate.opsForHash().put(key, "issueBeginTime", simpleDateFormat.format(coupon.getIssueBeginTime()));
            // 结束领取时间
            redisTemplate.opsForHash().put(key, "issueEndTime", simpleDateFormat.format(coupon.getIssueEndTime()));
            // 还可以发放总数量
            redisTemplate.opsForHash().put(key, "totalNum", String.valueOf(coupon.getTotalNum()-coupon.getIssueNum()));
            // 单个用户限领的优惠券数量
            redisTemplate.opsForHash().put(key, "userLimit", String.valueOf(coupon.getUserLimit()));
        }
    }

    @Scheduled(cron ="0 * * * * *")
    public void checkFinishCouponStatus(){
        //先获取需要更新的优惠券id
        LambdaQueryWrapper<Coupon> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.le(Coupon::getIssueEndTime,new Date());
        queryWrapper.in(Coupon::getStatus, CouponStatus.ISSUING);
        List<Coupon> list = couponService.list(queryWrapper);

        //没有需要更新的优惠券
        if(list.isEmpty())
            return;

        //更新优惠券状态
        LambdaUpdateWrapper<Coupon> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.le(Coupon::getIssueEndTime,new Date());
        updateWrapper.in(Coupon::getStatus, CouponStatus.ISSUING);
        updateWrapper.set(Coupon::getStatus, CouponStatus.FINISHED);
        couponService.update(updateWrapper);

        //将需要更新的优惠券加入redis中
        for(Coupon coupon:list){
            redisTemplate.delete(RedisConstant.COUPON_CACHE_KEY_PREFIX + coupon.getId());
        }
    }
}
