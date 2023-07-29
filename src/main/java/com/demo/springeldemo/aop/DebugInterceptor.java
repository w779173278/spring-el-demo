package com.demo.springeldemo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DebugInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("{} start", invocation.getClass());
        Object proceed = invocation.proceed();
        log.info("{} end ", invocation.getClass());
        return proceed;
    }
}
