package com.wxw.account.dto.account;

import lombok.Data;
import org.springframework.context.annotation.Primary;

@Data
public class LoginByMobileCommand {

    //手机号
    private String mobile;

    // 区号
    private String areaCode;

    // 密码
    private String passWord;
}
