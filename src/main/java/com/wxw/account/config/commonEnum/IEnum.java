package com.wxw.account.config.commonEnum;

public interface IEnum<E extends Enum<?>, T> {

    T getValue();

    Integer getCode();
}
