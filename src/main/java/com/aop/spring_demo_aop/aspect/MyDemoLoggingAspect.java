package com.aop.spring_demo_aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with an @Before advice

    @Before("execution(public void addAccount(int))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=======>>> Executing @Before advice on addAccount");
    }

    @Before("execution( * remover*())")
    public void afrerRemoveAccountAdvice(){
        System.out.println("\n\nxuy udalish\n\n");
    }

    /**
     *
     * execution (modifiers-pattern ? return-type-pattern declaring-type-pattern? method-name-pattern
     * (param-pattern) throws pattern?
     *
     * execution( public void com.luv2code.aopdemo.dao.AccountDao.addAccount()
     *
     * for all class
     *
     * execution(public void addAccount()
     *
     *
     * for classes which start with add
     *
     * execution(public void add*()
     *
     * for all return type
     *
     * execution(public * processCreditCard()
     *
     * if we want to use for modifier we just delete it
     *
     * execution(* processCreditCard*())
     *
     * if in dao we don't have the method which we use for aspect
     * it does not throw exception only not work
     *
     * for method of specific class we use
     *
     * execution( public void com.aop.spring_demo_aop.aspect.AccountDAO.addAccount()
     *
     *
     *
     * Param type
     *
     * execution(public void addAccount() - non arg
     * execution(public void addAccount(String) - with param String
     * execution(public void addAccount(..) - 0 - unlimited params
     *
     */
}
