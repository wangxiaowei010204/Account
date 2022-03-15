package com.wxw.account.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wxw.account.config.common.ConstantKey;
import com.wxw.account.config.common.ThreadLocalUtil;
import com.wxw.account.config.redis.RedisKey;
import com.wxw.account.config.redis.RedisUtil;
import com.wxw.account.config.result.LogicException;
import com.wxw.account.config.result.ResultEnum;
import com.wxw.account.dto.account.Account;
import com.wxw.account.dto.account.AccountDto;
import com.wxw.account.dto.account.LoginByMobileCommand;
import com.wxw.account.dto.account.SetPwdByMobileCommand;
import com.wxw.account.repository.AccountRepository;
import com.wxw.account.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    /**
     * 手机号登录
     */
    @Override
    public AccountDto loginByMobile(LoginByMobileCommand loginByMobileCommand) throws LogicException, JsonProcessingException {
        if (loginByMobileCommand.getMobile() == null) {
            throw new LogicException("手机号有误", ResultEnum.USER_NOT_EXIST);
        }

        Account account = accountRepository.getAccountByMobile(loginByMobileCommand.getAreaCode(), loginByMobileCommand.getMobile());

        if (account == null) {
            throw new LogicException("手机号有误", ResultEnum.USER_NOT_EXIST);
        }

        if (!account.getPassWord().equals(loginByMobileCommand.getPassWord())) {
            throw new LogicException("手机号有误", ResultEnum.USER_NOT_EXIST);
        }

        AccountDto accountDto = new AccountDto();
        accountDto.setAccountID(account.getAccountID());
        accountDto.setName(account.getName());
        accountDto.setImgUrl(account.getImgUrl());
        accountDto.setPrettyID(account.getPrettyID());
        accountDto.setAccessToken(createAccessToken());

        LocalDateTime dtNow = LocalDateTime.now();
        RedisUtil.set(RedisKey.getAccessTokenKey(accountDto.getAccessToken()), account, Duration.between(dtNow, dtNow.plusHours(5)).toMinutes() * 60);

        return accountDto;
    }

    /**
     * 根据手机号修改密码
     */
    @Override
    public boolean setPwdByMobile(SetPwdByMobileCommand setPwdByMobileCommand) throws LogicException {
        if (setPwdByMobileCommand.getMobile() == null) {
            throw new LogicException("手机号有误", ResultEnum.USER_NOT_EXIST);
        }
        if (setPwdByMobileCommand.getNewPassWord().equals(setPwdByMobileCommand.getPassWord())) {
            throw new LogicException("新老密码不能一样", ResultEnum.PASSWORD_SAME);
        }

        Account account = accountRepository.getAccountByMobile(setPwdByMobileCommand.getAreaCode(), setPwdByMobileCommand.getMobile());

        if (account == null) {
            throw new LogicException("手机号有误", ResultEnum.USER_NOT_EXIST);
        }

        boolean result = accountRepository.setPwdByMobile(account.getAccountID(), setPwdByMobileCommand.getNewPassWord());

        return true;
    }

    /**
     * 获取用户信息
     */
    @Override
    public AccountDto getUserInfo() {

        Account account= ThreadLocalUtil.get(ConstantKey.getUserInfoKey);

        AccountDto accountDto = new AccountDto();
        accountDto.setAccountID(account.getAccountID());
        accountDto.setName(account.getName());
        accountDto.setImgUrl(account.getImgUrl());
        accountDto.setPrettyID(account.getPrettyID());
        accountDto.setAccessToken(createAccessToken());

        return accountDto;
    }

    /**
     * 创建accessToken
     */
    private static String createAccessToken() {

        String token = UUID.randomUUID().toString().replace("-", "");
        return DigestUtils.md5DigestAsHex(token.getBytes());
    }
}
