package com.aop.spring_demo_aop.DAO;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    public void addAccount(int text){
        System.out.println(getClass() + " : Doing my work: adding an account");
    }

    public void removeAccount(){
        System.out.println("We want to remove this account");
    }
}
