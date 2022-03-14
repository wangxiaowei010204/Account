package com.wxw.account.web;

import com.wxw.account.config.annotation.AccessMapping;
import com.wxw.account.config.common.ThreadLocalUtil;
import com.wxw.account.config.result.LogicException;
import com.wxw.account.config.result.Result;
import com.wxw.account.config.result.ResultEnum;
import com.wxw.account.config.result.ResultUtil;
import com.wxw.account.dto.account.Account;
import com.wxw.account.dto.account.AccountDto;
import com.wxw.account.dto.account.LoginByMobileCommand;
import com.wxw.account.dto.account.SetPwdByMobileCommand;
import com.wxw.account.service.IAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户登录 controller
 */
@RestController
@RequestMapping("accountLogin")
@Api(tags = "用户信息管理")
public class AccountLoginController {

    @Autowired
    private IAccountService accountService;

    /**
     * 手机号登录
     */
    @PostMapping("loginByMobile")
    @ApiOperation(value = "手机号登录", notes = "通过手机号来登录")
    public Result loginByMobile(LoginByMobileCommand loginByMobileCommand) throws Exception {

        AccountDto result = accountService.loginByMobile(loginByMobileCommand);

        return ResultUtil.success(result);
    }

    /**
     * 根据手机号修改密码
     */
    @PostMapping("setPwdByMobile")
    @ApiOperation(value = "手机号修改密码", notes = "根据手机号修改密码")
    public Result setPwdByMobile(SetPwdByMobileCommand setPwdByMobileCommand) throws LogicException {

        boolean result = accountService.setPwdByMobile(setPwdByMobileCommand);

        return ResultUtil.success(result);
    }

    /**
     * 获取用户信息
     */
    @AccessMapping("getUserInfo")
    public Result getUserInfo() {
      
        AccountDto result = accountService.getUserInfo();

        return ResultUtil.success(1);
    }

}

















