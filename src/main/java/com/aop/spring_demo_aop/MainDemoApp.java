package com.aop.spring_demo_aop;

import com.aop.spring_demo_aop.DAO.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args){

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccountDao = context.getBean("accountDAO",AccountDAO.class);

        // call the business method
        theAccountDao.addAccount();


        theAccountDao.removeAccount();
        // do it again!

        System.out.println("\n let's do it again");

        // call the business method again
        theAccountDao.addAccount();



        // close the context
        context.close();
    }
}
