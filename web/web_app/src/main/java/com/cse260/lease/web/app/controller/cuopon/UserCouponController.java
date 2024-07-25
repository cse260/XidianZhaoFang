package com.cse260.lease.web.app.controller.cuopon;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cse260.lease.common.login.LoginUserHolder.LoginUserHolder;
import com.cse260.lease.common.result.Result;
import com.cse260.lease.model.enums.CouponStatus;
import com.cse260.lease.web.app.service.UserCouponService;
import com.cse260.lease.web.app.vo.coupon.CouponUserPageVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Tag(name =  "UserCoupon管理")
@RestController
@RequestMapping("/app/user-coupons")
public class UserCouponController {

    @Autowired
    private UserCouponService userCouponService;




    @Operation(summary ="用户领取优惠券")
    @PostMapping("receive")
    public Result receiveCoupon(@RequestParam Long id){
        userCouponService.receiveCoupon(id);
        return Result.ok();
    }




    @Operation(summary ="用户券列表-用户端")
    @GetMapping("page")
    public Result<IPage<CouponUserPageVo>> page(@RequestParam long current, @RequestParam long size, @RequestParam CouponStatus status){
        Page<CouponUserPageVo> page = new Page<>(current,size);
        Long userId= LoginUserHolder.getLoginUser().getUserId();
        IPage<CouponUserPageVo> result=userCouponService.pageItemByUserId(page,userId,status);
        return Result.ok(result);
    }

}
