package com.wxw.account.config.result;

import lombok.Data;

/*
 * 通用结果返回dto
 * */
@Data
public class Result<T> {

    private Integer code;
    private String msg;
    private T data;

    public Result() {
        super();
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
