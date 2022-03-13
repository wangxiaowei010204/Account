package com.wxw.account.config.redis;

public class RedisKey {

    /**
     * accessToken key
     */
    public static String getAccessTokenKey(String accessToken) {
        return "account:accessToken:"+accessToken;
    }
}
