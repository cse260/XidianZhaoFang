package com.cse260.lease.web.admin.controller.coupon;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cse260.lease.common.exception.LeaseException;
import com.cse260.lease.common.login.LoginUserHolder.LoginUserHolder;
import com.cse260.lease.common.result.Result;
import com.cse260.lease.common.result.ResultCodeEnum;
import com.cse260.lease.model.entity.Coupon;
import com.cse260.lease.model.enums.CouponStatus;
import com.cse260.lease.web.admin.dto.coupon.CouponIssueFormDTO;
import com.cse260.lease.web.admin.service.CouponService;
import com.cse260.lease.web.admin.vo.coupon.CouponDetailVo;
import com.cse260.lease.web.admin.vo.coupon.CouponPageVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Tag(name = "优惠券信息管理")
@RestController
@RequestMapping("/admin/coupons")
public class CouponController {

    @Autowired
    private  CouponService couponService;



    @Operation(summary ="新增或者修改优惠券")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody Coupon coupon) {
        //只能更新待发放的优惠券
        if (coupon.getId()!=null&&!coupon.getStatus().equals(CouponStatus.DRAFT)) {
            throw new LeaseException(ResultCodeEnum.ADMIN_COUPON_UPDATE_ERROR);
        }
        //获取操作者的id
        Long userId = LoginUserHolder.getLoginUser().getUserId();

        coupon.setUpdater(userId);
        //如果为新增优惠券
        if(coupon.getId()==null)
            coupon.setCreater(userId);
        couponService.saveOrUpdate(coupon);
        return Result.ok();
    }


    @Operation(summary ="管理端分页查询优惠券")
    @GetMapping("page")
    public Result<IPage<CouponPageVo>> page(@RequestParam long current, @RequestParam long size) {
        Page<CouponPageVo> page = new Page<>(current,size);
        IPage<CouponPageVo> result=couponService.pageCoupon(page);
        return Result.ok(result);
    }


    @Operation(summary ="发放优惠券")
    @PutMapping("issue")
    public Result issueCoupon( @RequestBody @Validated CouponIssueFormDTO dto) {
        couponService.issueCoupon(dto);
        return Result.ok();
    }



    @Operation(summary ="根据id查询优惠券详情")
    @GetMapping("getById")
    public Result<CouponDetailVo> getById(@RequestParam Long id) {
        CouponDetailVo couponDetailVo = couponService.selectCouponById(id);
        return  Result.ok(couponDetailVo);
    }


    @Operation(summary ="删除优惠券")
    @DeleteMapping("removeById")
    public Result removeById(@RequestParam Long id) {
         couponService.removeById(id);
         return Result.ok();
    }



    @Operation(summary ="暂停发放优惠券")
    @PutMapping("pause")
    public Result pauseIssueCoupon(@RequestParam Long id) {
        couponService.pauseIssueCoupon(id);
        return Result.ok();
    }

}
