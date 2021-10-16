package com.aop.spring_demo_app_two;

import com.aop.spring_demo_app_two.DAO.AccountDAO;
import com.aop.spring_demo_app_two.model.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunSpring {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        AccountDAO theAccountDao = context.getBean("accountDAO",AccountDAO.class);

        Account theAccount = new Account();
        theAccountDao.addAccount(theAccount, true);

        context.close();
    }
}
