package com.cse260.lease.web.admin.vo.coupon;


import com.cse260.lease.model.enums.DiscountType;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@Schema(description = "优惠券详细数据")
public class CouponDetailVo {
    @Schema(description ="优惠券id，新增不需要添加，更新必填")
    private Long id;

    @Schema(description ="优惠券名称")
    private String name;


    @Schema(description ="优惠券类型，1：每满减，2：折扣，3：无门槛，4：普通满减")
    private DiscountType discountType;

    @Schema(description ="折扣门槛，0代表无门槛")
    private Integer thresholdAmount;

    @Schema(description ="折扣值，满减填抵扣金额；打折填折扣值：80标示打8折")
    private Integer discountValue;

    @Schema(description ="最大优惠金额")
    private Integer maxDiscountAmount;

    @Schema(description ="发放开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date issueBeginTime;

    @Schema(description ="发放结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date issueEndTime;

    @Schema(description ="有效天数")
    private Integer termDays;

    @Schema(description ="使用有效期开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date termBeginTime;

    @Schema(description ="使用有效期结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date termEndTime;

    @Schema(description ="优惠券总量，如果为0代表无上限")
    private Integer totalNum;
    @Schema(description ="每人领取的上限")
    private Integer userLimit;
}
