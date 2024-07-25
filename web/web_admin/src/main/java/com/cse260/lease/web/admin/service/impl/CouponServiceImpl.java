package com.cse260.lease.web.admin.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cse260.lease.common.constant.RedisConstant;
import com.cse260.lease.common.exception.LeaseException;
import com.cse260.lease.common.result.ResultCodeEnum;
import com.cse260.lease.model.entity.Coupon;
import com.cse260.lease.model.enums.CouponStatus;
import com.cse260.lease.web.admin.dto.coupon.CouponIssueFormDTO;
import com.cse260.lease.web.admin.mapper.CouponMapper;
import com.cse260.lease.web.admin.service.CouponService;
import com.cse260.lease.web.admin.vo.coupon.CouponDetailVo;
import com.cse260.lease.web.admin.vo.coupon.CouponPageVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * 优惠券的规则信息 服务实现类
 * </p>
 *
 * @author Sakura
 */
@Service
@RequiredArgsConstructor
public class CouponServiceImpl extends ServiceImpl<CouponMapper, Coupon> implements CouponService {

    @Autowired
    private CouponMapper couponMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public IPage<CouponPageVo> pageCoupon(Page<CouponPageVo> page) {
        return couponMapper.pageCoupon(page);
    }

    @Override
    public CouponDetailVo selectCouponById(Long id) {
        Coupon coupon = couponMapper.selectById(id);
        CouponDetailVo couponDetailVo = new CouponDetailVo();
        BeanUtils.copyProperties(coupon,couponDetailVo);
        return couponDetailVo;
    }

    @Override
    public void issueCoupon( CouponIssueFormDTO dto) {
        // 校验id是否有效
        Coupon coupon = this.getById(dto.getId());
        if (coupon == null) {
            throw new LeaseException(ResultCodeEnum.ADMIN_COUPON_EXIST_ERROR);
        }
        // 校验当前优惠券状态，只有待发放和暂停状态才能执行发放操作
        if (coupon.getStatus() != CouponStatus.DRAFT && coupon.getStatus() != CouponStatus.PAUSE) {
            throw new LeaseException(ResultCodeEnum.ADMIN_COUPON_ISSUE_ERROR);
        }

        Date now = new Date();    // 获取当前时间
        // 判断是否立即发放，issueBeginTime为空或者小于等于当前时间
        boolean instantIssue = dto.getIssueBeginTime() == null || !dto.getIssueBeginTime().after(now);

        // 更新当前优惠券状态、领取开始和结束时间、使用开始和结束时间
        Coupon couponDB=new Coupon();
        BeanUtils.copyProperties(dto,couponDB);

        if (instantIssue) { // 立即发放
            // 领取开始时间前端不一定传，但领取结束时间前端必传
            couponDB.setStatus(CouponStatus.ISSUING);    // 更新当前优惠券状态为发放中
            couponDB.setIssueBeginTime(now);
        } else {
            couponDB.setStatus(CouponStatus.UN_ISSUE);  // 更新当前优惠券状态为未开始
        }

        // 更新优惠券信息
        this.updateById(couponDB);

        // 如果优惠券是立刻发放，将部分字段（优惠券id、开始领取时间、结束领取时间、已发放数量、发放总数量、限领数量）存入redis用于实现异步领取优惠券
        if (instantIssue) {  // 立即发放
            String key = RedisConstant.COUPON_CACHE_KEY_PREFIX + coupon.getId();   // 拼接key
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
            // 开始领取时间，转成Long方便比较
            redisTemplate.opsForHash().put(key, "issueBeginTime", simpleDateFormat.format(now));
            // 结束领取时间
            redisTemplate.opsForHash().put(key, "issueEndTime", simpleDateFormat.format((dto.getIssueEndTime())));
            // 还可以发放总数量
            redisTemplate.opsForHash().put(key, "totalNum", String.valueOf(coupon.getTotalNum()-coupon.getIssueNum()));
            // 单个用户限领的优惠券数量
            redisTemplate.opsForHash().put(key, "userLimit", String.valueOf(coupon.getUserLimit()));
        }
    }

    @Override
    public void pauseIssueCoupon(Long id) {
        // 校验优惠券id
        Coupon coupon = this.getById(id);
        if (coupon == null) {   // 判空
            throw new LeaseException(ResultCodeEnum.ADMIN_COUPON_EXIST_ERROR);
        }

        // 当前券状态必须是未开始或进行中
        CouponStatus status = coupon.getStatus();
        if (status != CouponStatus.UN_ISSUE && status != CouponStatus.ISSUING) {
            // 状态错误，直接结束
            return;
        }

        // 更新状态为暂停发放
        boolean success = lambdaUpdate()
                .set(Coupon::getStatus, CouponStatus.PAUSE)
                .eq(Coupon::getId, id)
                .in(Coupon::getStatus, CouponStatus.UN_ISSUE, CouponStatus.ISSUING)
                .update();
        if (!success) {
            // 可能是重复更新，结束
            log.error("重复暂停发放优惠券");
        }

        // 删除缓存
        redisTemplate.delete(RedisConstant.COUPON_CACHE_KEY_PREFIX + id);
    }


}
