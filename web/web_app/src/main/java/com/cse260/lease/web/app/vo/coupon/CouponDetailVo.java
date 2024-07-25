package com.cse260.lease.web.app.vo.coupon;

import com.baomidou.mybatisplus.annotation.TableField;
import com.cse260.lease.model.enums.CouponStatus;
import com.cse260.lease.model.enums.DiscountType;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@Schema(description = "用户端优惠券信息")
public class CouponDetailVo {
    @Schema(description = "优惠券id，新增不需要添加，更新必填")
    private Long id;

    @Schema(description = "优惠券名称")
    private String name;

    @Schema(description = "优惠券类型，1：每满减，2：折扣，3：无门槛，4：普通满减")
    private DiscountType discountType;

    @Schema(description = "折扣门槛，0代表无门槛")
    private Integer thresholdAmount;

    @Schema(description = "折扣值，满减填抵扣金额；打折填折扣值：80标示打8折")
    private Integer discountValue;

    @Schema(description = "最大优惠金额")
    private Integer maxDiscountAmount;

    @Schema(description = "有效天数")
    private Integer termDays;

    @Schema(description = "使用有效期结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date termEndTime;

    @Schema(description = "优惠券配置状态，1：待发放，2：未开始   3：进行中，4：已结束，5：暂停")
    @TableField("status")
    private CouponStatus status;

    @Schema(description = "已领取的数目")
    private Integer receivedCount;

    @Schema(description = "已使用的数目")
    private Integer usedCount;
}
