package com.aop.after_throwing;


import com.aop.after_throwing.dao.AccountDAO;
import com.aop.after_throwing.model.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class RunAspect {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call method to find the accounts

        List<Account> theAccounts = null;

        try{
            // add a boolean flag to simulate exceptions
            boolean tripWire = true;
            theAccounts = theAccountDAO.findAccounts(tripWire);
        } catch (Exception ex){
            System.out.println("\n\nMain Program ... caught exception: " + ex);
        }

        // display the accounts
        System.out.println("\n\nMain Program: AfterThrowingDemoApp");
        System.out.println("----");

        System.out.println(theAccounts);

        System.out.println("\n");

        context.close();
    }
}
