package com.cse260.lease.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;



public enum CouponStatus implements BaseEnum {
    DRAFT(1, "待发放"),
    UN_ISSUE(2, "未开始"),
    ISSUING(3, "发放中"),
    FINISHED(4, "发放结束"),
    PAUSE(5, "暂停");

    @EnumValue
    @JsonValue
    private Integer code;


    private String name;

    CouponStatus(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
