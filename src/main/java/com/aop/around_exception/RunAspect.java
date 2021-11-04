package com.aop.around_exception;


import com.aop.around_exception.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class RunAspect {

    private static Logger myLogger = Logger.getLogger(RunAspect.class.getName());

    public static void main(String[] args){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);


//        System.out.println("\nMain Program: Around Demo");
//
//        System.out.println("Calling get fortune");
//
//        String data = theFortuneService.getFortune();
//
//        System.out.println("\nMy fortune is: " + data);
//
//        System.out.println("Finished");

        // with logger

        myLogger.info("\nMain Program: Around Demo");

        myLogger.info("Calling get fortune");

        String data = theFortuneService.getFortune();

        myLogger.info("\nMy fortune is: " + data);

        myLogger.info("Finished");

        context.close();
    }
}
