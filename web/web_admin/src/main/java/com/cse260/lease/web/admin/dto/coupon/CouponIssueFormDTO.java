package com.cse260.lease.web.admin.dto.coupon;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Schema(description = "优惠券发放的表单实体")
public class CouponIssueFormDTO {
    @Schema(description ="优惠券id")
    private Long id;

    @Schema(description ="发放开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Future(message = "发放开始时间必须晚于当前时间")
    private Date issueBeginTime;

    @Schema(description ="发放结束时间")
    @Future(message = "发放结束时间必须晚于当前时间")
    @NotNull(message = "发放结束时间不能为空")
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
}
