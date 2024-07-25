package com.cse260.lease.web.app.controller.cuopon;


import com.cse260.lease.common.result.Result;
import com.cse260.lease.web.app.service.CouponService;
import com.cse260.lease.web.app.vo.coupon.CouponVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Tag(name = "优惠券信息管理")
@RestController
@RequestMapping("/app/coupons")
public class CouponController {

    @Autowired
    private CouponService couponService;


    @Operation(summary ="查询未开始和发放中的优惠券列表")
    @GetMapping("list")
    public Result<List<CouponVo>> list(){
        List<CouponVo> result=couponService.listItem();
        return Result.ok(result);
    }
}
