package com.aop.web_customer_tracker_aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

    // setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    // setup pointcut declarations
    @Pointcut("execution(* com.aop.web_customer_tracker_aop.controller.*.*(..))")
    private void forControllerPackage(){}

    // do the same for service and dao
    @Pointcut("execution(* com.aop.web_customer_tracker_aop.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.aop.web_customer_tracker_aop.DAO.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow(){}

    // add @Before advice

    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint){
        // display method we are calling
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("====>>> in @Before: calling method" + theMethod);

        // display the arguments to the method

        // get arguments
        Object[] args = theJoinPoint.getArgs();
        // loop thru and display args
        for(Object tempArg : args){
            myLogger.info("====>> argument: " + tempArg);
        }
    }

    // add @AfterReturning advice
}
