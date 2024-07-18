package com.cse260.lease.common.exception;

import com.cse260.lease.common.result.ResultCodeEnum;
import lombok.Data;
@Data
public class LeaseException extends RuntimeException{

    private Integer code;

    public LeaseException(Integer code,String message){
        super(message);
        this.code=code;
    }

    public LeaseException(ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMessage());
        this.code=resultCodeEnum.getCode();
    }
}
