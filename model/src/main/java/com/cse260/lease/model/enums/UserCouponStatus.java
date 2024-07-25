package com.cse260.lease.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserCouponStatus implements BaseEnum {
    UNUSED(1, "未使用"),
    USED(2, "已使用"),
    EXPIRED(3, "已过期"),
    ;
    @EnumValue
    @JsonValue
    private Integer code;

    private String name;


    UserCouponStatus(Integer code, String name) {
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
