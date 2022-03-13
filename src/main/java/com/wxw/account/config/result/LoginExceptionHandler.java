package com.wxw.account.config.result;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Order(1)
@RestController
@ControllerAdvice(basePackages = "com.wxw.account")
@Slf4j
public class LoginExceptionHandler {

    //全局异常
    @ResponseBody
    @ExceptionHandler(value = LogicException.class)
    public Result exceptionHandler(Exception ex) {

        log.info("我的自定义异常:" + ex);

        LogicException logicException = (LogicException) ex;

        Result result = ResultUtil.error(logicException.getResultEnum().getCode(), logicException.getMessage());
        return result;
    }
}
