package com.cse260.lease.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cse260.lease.model.enums.CouponStatus;
import com.cse260.lease.model.enums.DiscountType;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;


@Schema(description = "优惠券的规则信息")
@Data
@TableName("coupon")
public class Coupon extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "优惠券名称，可以和活动名称保持一致")
    @TableField("name")
    private String name;

    @Schema(description = "优惠券类型，1：普通券。目前就一种，保留字段")
    @TableField("type")
    private Integer type;

    @Schema(description = "优惠券类型，1：每满减，2：折扣，3：无门槛，4：普通满减")
    @TableField("discount_type")
    private DiscountType discountType;


    @Schema(description = "折扣值，如果是满减则存满减金额，如果是折扣，则存折扣率，8折就是存80")
    @TableField("discount_value")
    private Integer discountValue;

    @Schema(description = "使用门槛，0：表示无门槛，其他值：最低消费金额")
    @TableField("threshold_amount")
    private Integer thresholdAmount;

    @Schema(description = "最高优惠金额，满减最大，0：表示没有限制，不为0，则表示该券有金额的限制")
    @TableField("max_discount_amount")
    private Integer maxDiscountAmount;

    @Schema(description = "开始发放时间")
    @TableField("issue_begin_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date issueBeginTime;

    @Schema(description = "结束发放时间")
    @TableField("issue_end_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date issueEndTime;

    @Schema(description = "优惠券有效期天数，0：表示有效期是指定有效期的")
    @TableField("term_days")
    private Integer termDays;

    @Schema(description = "优惠券有效期开始时间")
    @TableField("term_begin_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date termBeginTime;

    @Schema(description = "优惠券有效期结束时间")
    @TableField("term_end_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date termEndTime;

    @Schema(description = "优惠券配置状态，1：待发放，2：未开始   3：进行中，4：已结束，5：暂停")
    @TableField("status")
    private CouponStatus status;

    @Schema(description = "总数量，不超过5000")
    @TableField("total_num")
    private Integer totalNum;

    @Schema(description = "已发行数量，用于判断是否超发")
    @TableField("issue_num")
    private Integer issueNum;

    @Schema(description = "已使用数量")
    @TableField("used_num")
    private Integer usedNum;

    @Schema(description = "每个人限领的数量，默认1")
    @TableField("user_limit")
    private Integer userLimit;

    @Schema(description = "创建人")
    @TableField("creater")
    private Long creater;

    @Schema(description = "更新人")
    @TableField("updater")
    private Long updater;
}
