package com.wxw.account;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableAsync
@MapperScan("com.wxw.account.repository")
@Slf4j
@EnableOpenApi
@EnableWebMvc
public class AccountApplication {

    public static void main(String[] args) {

        log.info("spring boot version:" + SpringBootVersion.getVersion());
        log.info("spring version:" + SpringVersion.getVersion());
        SpringApplication.run(AccountApplication.class, args);
    }

}
