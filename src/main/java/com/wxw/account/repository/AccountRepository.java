package com.wxw.account.repository;

import com.wxw.account.dto.account.Account;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository {

    /**
     * 根据手机号获取用户信息
     */
    Account getAccountByMobile(@Param("area") String area, @Param("mobile") String mobile);

    /**
     * 根据手机号修改密码
     */
    boolean setPwdByMobile(@Param("accountID") long accountID, @Param("passWord") String passWord);
}
