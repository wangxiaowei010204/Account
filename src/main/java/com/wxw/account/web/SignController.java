package com.wxw.account.web;

import com.wxw.account.config.annotation.AccessMapping;
import com.wxw.account.config.result.Result;
import com.wxw.account.config.result.ResultUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("sign")
@Api(tags = "签到接口")
public class SignController {

    /**
     * @return:
     * @author:
     * @date: 2022/3/15 8:12 下午
     * @description: 获取签到信息
     */
    @AccessMapping("getSignInfo")
    public Result getSignInfo() {



        return ResultUtil.success(1);

    }

}
