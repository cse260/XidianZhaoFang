package com.cse260.lease.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;


public enum DiscountType implements BaseEnum {
    PER_PRICE_DISCOUNT(1, "每满减"),
    RATE_DISCOUNT(2, "折扣"),
    NO_THRESHOLD(3, "无门槛"),
    PRICE_DISCOUNT(4, "满减");
    @EnumValue
    @JsonValue
    private Integer code;


    private String name;

    DiscountType(Integer code, String name) {
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
