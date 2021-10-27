package com.aop.spring_aop_order.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectMain {
    @Pointcut("execution(* com.aop.spring_aop_order.dao.*.*(..))")
    public void mainAspectFunc(){}


}
