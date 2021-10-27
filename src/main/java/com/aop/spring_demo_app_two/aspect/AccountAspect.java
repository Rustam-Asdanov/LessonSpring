package com.aop.spring_demo_app_two.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountAspect {

    @Pointcut("execution(* add*(com.aop.spring_demo_app_two.model.Account, ..))")
    public void pointMethod(){}

    @Order(1)
    @Before("pointMethod()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====>>> Executing @Before advice on method one");
    }

    @Order(7)
    @Before("pointMethod()")
    public void beforeAddAccountAdviceTwo(){
        System.out.println("\n=====>>> Executing @Before advice on method two");
    }

    @Order(5)
    @Before("pointMethod()")
    public void beforeAddAccountAdviceThree(){
        System.out.println("\n=====>>> Executing @Before advice on method three");
    }

}
