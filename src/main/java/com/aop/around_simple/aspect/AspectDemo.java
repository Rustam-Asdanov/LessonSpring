package com.aop.around_simple.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class AspectDemo {

    private static Logger myLogger = Logger.getLogger(AspectDemo.class.getName());

    @Around("execution(* com.aop.around_simple.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint theProceedingJoinPoint
    ) throws Throwable {

        // print out method we are advising on
        String method = theProceedingJoinPoint.getSignature().toLongString();
        System.out.println("\n=====>>> Executing @Around on method: " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // now, let's execute the method
        Object result = null;

        try{
            result = theProceedingJoinPoint.proceed();

        } catch (RuntimeException ex){
            // log the exception
            myLogger.warning("ex.getMessage()");


            // give user a custom message
//            result = "Major accident! But no worries, your " +
//                    "private AOP helicopter is on the way!";
            // rethrow exception
            throw ex;

        }


        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        System.out.println("\n ===== >> Duration: " + duration/1000.0 + " seconds");

        return result;
    }

}
