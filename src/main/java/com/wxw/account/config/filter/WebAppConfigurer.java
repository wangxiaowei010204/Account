package com.wxw.account.config.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {

    /**
     * 注入自定义拦截器
     *
     * @param registry
     * @Title: addInterceptors
     * @Description: 先add的拦截器会越靠外，即越靠近浏览器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(new CustomInterceptor()).addPathPatterns("/**");//拦截所有请求
    }

}
