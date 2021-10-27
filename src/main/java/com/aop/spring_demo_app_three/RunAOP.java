package com.aop.spring_demo_app_three;

import com.aop.spring_demo_app_three.DAO.AccountDAO;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class RunAOP {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfigAOP.class);

        AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
        theAccountDAO.setName("foobar");
        theAccountDAO.setServiceCode("silver");

//        String name = theAccountDAO.getName();
//        String code = theAccountDAO.getServiceCode();



        context.close();
    }

}
