package com.wxw.account.service;

import com.wxw.account.dto.sign.SignInfoDto;

import java.util.List;

/**
 * @author: louyanping
 * @date: 2022/3/15 8:29 下午
 * @description:
 */
public interface ISignService {

    /**
     * 获取签到接口信息
     *
     * @return: List<SignInfoDto>
     * @author:
     * @date: 2022/3/15 8:30 下午
     * @description:
     */
    List<SignInfoDto> getSignInfos();
}
