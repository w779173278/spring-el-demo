package com.demo.springeldemo.aop;

import com.demo.springeldemo.core.AopTest;
import lombok.NonNull;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.annotation.AnnotationMethodMatcher;

//@Component
public class AopTestPointcut implements Pointcut {
    @Override
    @NonNull
    public ClassFilter getClassFilter() {
        return c -> true;

    }

    @Override
    @NonNull
    public MethodMatcher getMethodMatcher() {
        return new AnnotationMethodMatcher(AopTest.class);
    }


}
