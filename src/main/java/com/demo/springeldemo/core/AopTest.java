package com.demo.springeldemo.core;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AopTest {
    @AliasFor("key")
    String value() default "";

    @AliasFor("value")
    String key() default "";
}
