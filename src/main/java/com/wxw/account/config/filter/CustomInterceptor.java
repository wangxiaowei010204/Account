package com.wxw.account.config.filter;

import com.wxw.account.config.annotation.AccessMapping;
import com.wxw.account.config.common.ConstantKey;
import com.wxw.account.config.common.ThreadLocalUtil;
import com.wxw.account.config.redis.RedisKey;
import com.wxw.account.config.redis.RedisUtil;
import com.wxw.account.config.result.LogicException;
import com.wxw.account.config.result.ResultEnum;
import com.wxw.account.dto.account.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通用拦截器
 */
@Slf4j
public class CustomInterceptor implements HandlerInterceptor {


    private final String nonce = "accountNonce";

    /**
     * 在请求处理之前执行，主要用于权限验证、参数过滤等
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        log.info("CustomInterceptor ==> preHandle method: do request before");

        if (request.getRequestURI().contains("/swagger-") || request.getRequestURI().contains("/api-docs")) {
            return true;
        }

        String nonce = request.getHeader("nonce");
        if (nonce == null || nonce.isEmpty() || !nonce.equals(nonce)) {
            throw new LogicException("nonce 非法!", ResultEnum.NONCE_IS_NULL);
        }

        if (((HandlerMethod) handler).getMethod().getAnnotation(AccessMapping.class) != null) {

            String accessToken = request.getHeader("accessToken");
            if (accessToken == null) {
                throw new LogicException("非法请求", ResultEnum.ILEEGAL_REQUEST);
            }

            Account account = (Account) RedisUtil.get(RedisKey.getAccessTokenKey(accessToken));
            if (account == null) {
                throw new LogicException("非法请求", ResultEnum.ILEEGAL_REQUEST);
            }

            ThreadLocalUtil.put(ConstantKey.getUserInfoKey, account);
        }

        return true;
    }
}
