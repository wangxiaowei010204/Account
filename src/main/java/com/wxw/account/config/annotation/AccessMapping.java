package com.wxw.account.config.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(
        method = {RequestMethod.POST}
)
public @interface AccessMapping {

    @AliasFor(annotation = RequestMapping.class)
    String[] value() default {};

}
