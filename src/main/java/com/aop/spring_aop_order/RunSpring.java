package com.aop.spring_aop_order;

import com.aop.spring_aop_order.dao.AccountDAO;
import com.aop.spring_aop_order.model.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunSpring {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        AccountDAO theAccountDao = context.getBean("accountDAO",AccountDAO.class);

        theAccountDao.addAccount();

        System.out.println();
        System.out.println();
        System.out.println();

        Account theAccount = new Account();
        theAccount.setName("Andrey");
        theAccount.setMail("yehoo");

        theAccountDao.addAccount(theAccount,"false");

        context.close();
    }
}
