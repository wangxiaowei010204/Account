package com.wxw.account.dto.account;

import com.wxw.account.config.commonEnum.SexEnum;
import lombok.Data;

@Data
public class AccountDto {

    private long accountID;
    private long prettyID;
    private String name;
    private String imgUrl;
    private SexEnum sexEnum;
    private String accessToken;
    private String refreshToken;
}
