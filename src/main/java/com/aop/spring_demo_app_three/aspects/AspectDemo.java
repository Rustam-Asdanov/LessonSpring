package com.aop.spring_demo_app_three.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectDemo {

    @Pointcut("execution (* com.aop.spring_demo_app_three.DAO.*.*(..))")
    private void forDaoPackage(){}

    // create for getter methods
    @Pointcut("execution (* com.aop.spring_demo_app_three.DAO.*.get*(..))")
    private void getter(){}

    //create for setter methods
    @Pointcut("execution (* com.aop.spring_demo_app_three.DAO.*.set*(..))")
    private void setter(){}

    // create pointcut include package ... exclude getter/ setter
//    @Pointcut("forDaoPackage() && !(getter() && setter())")
    @Pointcut("getter() && setter()")
    private void forDaoPackageNoGetterSetter(){}

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice(){
        System.out.println("method one");
    }

    @Before("forDaoPackage()")
    public void performApiAnalythics(){
        System.out.println("method two");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void runMethod(){
        System.out.println("====>>>>  without setter and getter");
    }
}
