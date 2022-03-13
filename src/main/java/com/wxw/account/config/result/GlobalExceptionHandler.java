package com.wxw.account.config.result;

import com.wxw.account.config.result.Result;
import com.wxw.account.config.result.ResultEnum;
import com.wxw.account.config.result.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Order(2)
@RestController
@ControllerAdvice(basePackages = "com.wxw.account")
@Slf4j
public class GlobalExceptionHandler {

    //全局异常
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(Exception ex) {

        if (ex instanceof LogicException) {
            log.info("自定义异常:" + ex);

            LogicException logicException = (LogicException) ex;

            Result result = ResultUtil.error(logicException.getResultEnum().getCode(), logicException.getMessage());
            return result;
        }

        log.info("未知错误:" + ex);

        Result result = ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(), ex.toString());
        return result;
    }
}
