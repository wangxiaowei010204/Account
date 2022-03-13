package com.wxw.account.config.commonEnum;

/**
 * 性别枚举
 */
public enum SexEnum implements IEnum<SexEnum, String> {

    MALE(1,"男性"),
    FEMALE(2,"女性"),
    UNKNOWN(3,"未知");

    private Integer code;
    private String msg;

    SexEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getValue() {
        return msg;
    }
}
