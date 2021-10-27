package com.aop.spring_aop_order.aspect;

import com.aop.spring_aop_order.dao.AccountDAO;
import com.aop.spring_aop_order.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class AspectTwo {

    @Before("com.aop.spring_aop_order.aspect.AspectMain.mainAspectFunc()")
    public void functionTwo(JoinPoint theJoinPoint){
        System.out.println(getClass() + "function two");

        // display method signature

        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        // display method arguments

        // get args
        Object[] args = theJoinPoint.getArgs();

        // loop thru args

        for(Object temoArg : args){
            System.out.println(temoArg);

            if (temoArg instanceof Account){
                // downcast and print Account specific stuff

                Account theAccount = (Account) temoArg;

                System.out.println("account name: " + theAccount.getName());
                System.out.println("account mail: " + theAccount.getMail());
            }
        }

    }
}
