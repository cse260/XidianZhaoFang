package com.cse260.lease.common.exception;

import com.cse260.lease.common.result.Result;
import kotlin.contracts.ExperimentalContracts;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    //@ExceptionHandler捕获不同类型的异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        e.printStackTrace();
        return Result.fail();
    }


    @ExceptionHandler(LeaseException.class)
    @ResponseBody
    public Result handle(LeaseException e){
        e.printStackTrace();
        return Result.fail(e.getCode(), e.getMessage());
    }
}
