package com.carbon_trading.handler;

// handler/GlobalExceptionHandler.java

import com.carbon_trading.common.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = {"com.carbon_trading.controller"}, annotations = {RestController.class})
public class GlobalExceptionHandler {

    //处理异常
    @ExceptionHandler(Exception.class) //指定能够处理的异常类型
    public Result ex(Exception e) {
        e.printStackTrace();//打印堆栈中的异常信息
        //捕获到异常之后，响应一个标准的Result
        if (e.getMessage() != null) {
            return Result.error(e.getMessage());
        }
        return Result.error("对不起,操作失败,请联系管理员");
    }
}