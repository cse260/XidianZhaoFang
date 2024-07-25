package com.cse260.lease.web.admin.dto.coupon;


import com.cse260.lease.model.enums.DiscountType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Schema(description = "优惠券表单数据")
public class CouponFormDTO {

    @Schema(description ="优惠券id，新增不需要添加，更新必填")
    private Long id;

    @Schema(description ="优惠券名称")
    @NotNull(message = "优惠券名称不能为空")
    @Size(max = 20, min = 4, message = "优惠券名称长度错误")
    private String name;


    @Schema(description ="优惠券使用范围")
    private List<Long> scopes;

    @Schema(description ="优惠券类型，1：每满减，2：折扣，3：无门槛，4：普通满减")
    @NotNull(message = "优惠券折扣类型不能为空")
    private DiscountType discountType;

    @Schema(description ="折扣门槛，0代表无门槛")
    private Integer thresholdAmount;

    @Schema(description ="折扣值，满减填抵扣金额；打折填折扣值：80标示打8折")
    private Integer discountValue;

    @Schema(description ="最大优惠金额")
    private Integer maxDiscountAmount;

    @Schema(description ="优惠券总量")
    private Integer totalNum;

    @Schema(description ="每人领取的上限")
    private Integer userLimit;


}