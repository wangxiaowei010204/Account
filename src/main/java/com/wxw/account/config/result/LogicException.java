package com.wxw.account.config.result;

import lombok.Data;

/**
 * 自定义业务异常
 */
@Data
public class LogicException extends Exception {

    private String message;
    private Exception innerException;
    private ResultEnum resultEnum;

    public LogicException(String message, ResultEnum resultEnum) {
        this.message = message;
        this.resultEnum = resultEnum;
    }

    public LogicException(String message, ResultEnum resultEnum, Exception innerException) {
        this.message = message;
        this.resultEnum = resultEnum;
        this.innerException = innerException;
    }
}
