package com.cse260.lease.web.app.service.impl;

import com.cse260.lease.model.entity.Coupon;
import com.cse260.lease.web.app.mapper.CouponMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@SpringBootTest
class UserCouponServiceImplTest {
    @Autowired
    private UserCouponServiceImpl userCouponServiceimpl;

    @Autowired
    private CouponMapper couponMapper;

    @Test
    void  q(){
        Coupon coupon=couponMapper.selectById(1L);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
        System.out.println(simpleDateFormat.format(coupon.getIssueBeginTime()));
    }
    @Test
    void f(){

            Date termBeginTime = new Date();
            // 使用Calendar类给日期加一天
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(termBeginTime);
            calendar.add(Calendar.DATE, 30);
            Date termEndTime = calendar.getTime();
        System.out.println("Next Day: " + formatDate(termEndTime));
    }

    // 辅助方法，用于格式化Date对象为字符串
    private static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
}