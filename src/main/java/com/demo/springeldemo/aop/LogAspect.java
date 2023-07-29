package com.demo.springeldemo.aop;

import com.demo.springeldemo.core.AopTest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.Method;
import java.util.Objects;

@Slf4j
@Aspect
public class LogAspect {
    @Pointcut("@annotation(com.demo.springeldemo.core.AopTest)")
    public void pointcut() {
    }


    @Before("pointcut()")
    public void before() {
        log.info("Before AopTest注解方法执行之前。。。。");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String[] parameterNames = signature.getParameterNames();
        Object[] args = joinPoint.getArgs();
        AopTest annotation = AnnotationUtils.findAnnotation(method, AopTest.class);
        SpelExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        for (int i = 0; i < parameterNames.length; i++) {
            context.setVariable(parameterNames[i], args[i]);
        }

        Object value = parser.parseExpression(Objects.requireNonNull(annotation).key()).getValue(context);
        log.info("AOP 解析的数据：{}", value);
        return joinPoint.proceed();
    }




}