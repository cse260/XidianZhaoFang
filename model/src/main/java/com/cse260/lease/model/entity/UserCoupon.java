package com.cse260.lease.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cse260.lease.model.enums.UserCouponStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;


@Data
@TableName("user_coupon")
@Schema(description ="用户领取优惠券的记录，是真正使用的优惠券信息")
public class UserCoupon extends BaseEntity {

    private static final long serialVersionUID = 1L;

    
    @Schema(description = "优惠券的拥有者id")
    @TableField(value = "user_id")
    private Long userId;

    @Schema(description = "优惠券模板id")
    @TableField(value = "coupon_id")
    private Long couponId;

    @Schema(description = "优惠券有效期开始时间")
    @TableField(value = "term_begin_time")
    private Date termBeginTime;

    @Schema(description = "优惠券有效期结束时间")
    @TableField(value = "term_end_time")
    private Date termEndTime;

    @Schema(description = "优惠券使用时间（核销时间）")
    @TableField(value = "used_time")
    private Date usedTime;

    @Schema(description = "优惠券状态，1：未使用，2：已使用，3：已失效")
    @TableField(value = "status")
    private UserCouponStatus status;
    


}
