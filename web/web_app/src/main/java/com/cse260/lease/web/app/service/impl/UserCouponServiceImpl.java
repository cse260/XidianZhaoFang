package com.cse260.lease.web.app.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cse260.lease.common.constant.MqConstants;
import com.cse260.lease.common.constant.RedisConstant;
import com.cse260.lease.common.exception.LeaseException;
import com.cse260.lease.common.login.LoginUserHolder.LoginUserHolder;
import com.cse260.lease.common.rabbitmq.RabbitMqHelper;
import com.cse260.lease.common.result.ResultCodeEnum;
import com.cse260.lease.model.entity.Coupon;
import com.cse260.lease.model.entity.UserCoupon;
import com.cse260.lease.model.enums.CouponStatus;
import com.cse260.lease.web.app.dto.coupon.UserCouponDTO;
import com.cse260.lease.web.app.mapper.CouponMapper;
import com.cse260.lease.web.app.mapper.UserCouponMapper;
import com.cse260.lease.web.app.service.UserCouponService;
import com.cse260.lease.web.app.vo.coupon.CouponUserPageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
* @author cse
* @description 针对表【user_coupon(用户领取优惠券的记录，是真正使用的优惠券信息)】的数据库操作Service实现
* @createDate 2024-07-19 15:16:18
*/
@Service
public class UserCouponServiceImpl extends ServiceImpl<UserCouponMapper, UserCoupon>
    implements UserCouponService{

    @Autowired
    private CouponMapper couponMapper;
    @Autowired
    private UserCouponMapper userCouponMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private RabbitMqHelper rabbitMqHelper;
    @Override
    public IPage<CouponUserPageVo> pageItemByUserId(Page<CouponUserPageVo> page, Long userId, CouponStatus status) {
        return userCouponMapper.pageItemByUserId(page,userId,status);
    }




    @Override
     //对优惠券加锁，防止超卖问题
    public void  receiveCoupon(Long id) {
        synchronized(id.toString().intern()) {
            // 从redis中获取优惠券信息
            Coupon coupon = queryCouponFromRedis(id);
            if (coupon == null) {
                throw new LeaseException(ResultCodeEnum.PARAM_ERROR);
            }
            // 校验时间是否在领取开始时间 issue_begin_time 和 领取结束时间 issue_end_time区间内
            Date now = new Date();
            if (now.before(coupon.getIssueBeginTime()) || now.after(coupon.getIssueEndTime())) {
                throw new LeaseException(ResultCodeEnum.APP_COUPON_STATUS_ERROR);
            }

            // 判断优惠券余量
            if (coupon.getTotalNum() <= 0) {
                throw new LeaseException(ResultCodeEnum.APP_COUPON_COUNT_LACK);
            }

            // 校验当前用户是否已达到该优惠券的领取上限
            Long userId = LoginUserHolder.getLoginUser().getUserId();
            String key = RedisConstant.USER_COUPON_CACHE_KEY_PREFIX + id;
            // 获取用户已领取数量+1，再判断是否超过上限，delta表示增量
            Long increment = redisTemplate.opsForHash().increment(key, userId.toString(), 1);
            if (increment > coupon.getUserLimit()) {   // 超出限领数量
                // redis用户已领取优惠券数量减1
                redisTemplate.opsForHash().increment(key, userId.toString(), -1);
                throw new LeaseException(ResultCodeEnum.APP_COUPON_EXCEED_LIMIT);
            }
            // 更新优惠券的可发放数量-1
            redisTemplate.opsForHash().increment(RedisConstant.COUPON_CACHE_KEY_PREFIX + id, "totalNum", -1);

            // 发送RabbitMQ消息，userId，couponId，即哪个用户需要新增用户券
            UserCouponDTO msg = new UserCouponDTO();
            msg.setUserId(userId);
            msg.setCouponId(id);
            rabbitMqHelper.send(MqConstants.COUPON_EXCHANGE, MqConstants.COUPON_RECEIVE, msg);
        }
     }

    //从redis中获取优惠券信息
    public Coupon queryCouponFromRedis(Long couponId) {
        String key = RedisConstant.COUPON_CACHE_KEY_PREFIX + couponId;   // 拼接key
        Map<Object, Object> entries = redisTemplate.opsForHash().entries(key);  // 获取所有键值对，底层是hgetall命令
        if (entries.isEmpty()) {    // 查询不到，返回null
            return null;
        }
        System.out.println(entries);
        // 反序列返回实现map转entity
        return BeanUtil.mapToBean(entries, Coupon.class, false,CopyOptions.create());
    }


    /**
     * 校验当前用户是否已达到该优惠券的领取上限
     * 优惠券已发放数量+1
     * 保存用户券
     * #{userId}：使用SPEL表达式，对应着形参名称userId
     * 更新，移除锁
     * 更新，如果是兑换码领券，需要更新兑换码状态
     */
    @Transactional
    @Override
    public void createUserCoupon(UserCouponDTO msg) {
        // 1.从db中查询优惠券(因为Redis的优惠券信息较少)
        Coupon coupon = couponMapper.selectById(msg.getCouponId());
        if (coupon == null) {
            throw new LeaseException(ResultCodeEnum.ADMIN_COUPON_EXIST_ERROR);
        }

        // 优惠券已发放数量+1
        int num = couponMapper.increaseIssueNum(coupon.getId());
        if (num == 0) { // num 为 0即更新失败，需要抛出异常，触发回滚
            throw new LeaseException(ResultCodeEnum.APP_COUPON_COUNT_LACK);
        }

        Long userId = msg.getUserId();
        // 保存用户券
        saveUserCoupon(userId, coupon);
    }





    /**
     * 保存用户券
     *
     * @param userId 用户id
     * @param coupon 优惠券信息
     */
    private void saveUserCoupon(Long userId, Coupon coupon) {
        UserCoupon userCoupon = new UserCoupon();
        userCoupon.setCouponId(coupon.getId());
        userCoupon.setUserId(userId);
        Date termBeginTime = coupon.getTermBeginTime();    //  优惠券领取开始时间
        Date termEndTime = coupon.getTermEndTime();    // 优惠券领取结束时间
        // 优惠券领取开始时间和结束时间需要校验下
        if (termBeginTime == null && termEndTime == null) {  // 前端传参决定
            termBeginTime = new Date();
            // 使用Calendar类给日期加一天
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(termBeginTime);
            calendar.add(Calendar.DATE, coupon.getTermDays());
            termEndTime = calendar.getTime();
        }

        userCoupon.setTermBeginTime(termBeginTime);
        userCoupon.setTermEndTime(termEndTime);
        this.save(userCoupon);
    }
}




