package com.aop.spring_aop_order.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class AspectThree {

    @Before("com.aop.spring_aop_order.aspect.AspectMain.mainAspectFunc()")
    public void functionThree(){
        System.out.println(getClass() + "function three");
    }
}
