package com.cse260.lease.web.app.dto.coupon;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description ="用户-优惠券")
public class UserCouponDTO {

    @Schema(description ="用户id")
    private Long userId;

    @Schema(description ="优惠券id")
    private Long couponId;
}
