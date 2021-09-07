package com.king.exampleAnnotation;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunSpring {
    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Company company = context.getBean("com",Company.class);

        company.getProduct();

//        System.out.println(company.getTypeName());

        context.close();
    }
}
