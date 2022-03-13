package com.wxw.account.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wxw.account.config.result.LogicException;
import com.wxw.account.config.result.Result;
import com.wxw.account.dto.account.AccountDto;
import com.wxw.account.dto.account.LoginByMobileCommand;
import com.wxw.account.dto.account.SetPwdByMobileCommand;

public interface IAccountService {

    /**
     * 手机号登录
     */
    AccountDto loginByMobile(LoginByMobileCommand loginByMobileCommand) throws LogicException, JsonProcessingException;

    /**
     * 根据手机号修改密码
     */
    boolean setPwdByMobile(SetPwdByMobileCommand setPwdByMobileCommand) throws LogicException;

    /**
     * 获取用户信息
     */
    AccountDto getUserInfo();
}
