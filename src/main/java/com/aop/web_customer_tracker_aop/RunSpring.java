package com.aop.web_customer_tracker_aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class RunSpring {
    public static void main(String[] args){

        SpringApplication.run(RunSpring.class);
        System.out.println("Success");
    }
}
