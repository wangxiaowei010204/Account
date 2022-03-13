package com.wxw.account.dto.account;

import lombok.Data;

@Data
public class SetPwdByMobileCommand {

    //手机号
    private String mobile;

    // 区号
    private String areaCode;

    // 密码
    private String passWord;

    //新密码
    private String newPassWord;
}
