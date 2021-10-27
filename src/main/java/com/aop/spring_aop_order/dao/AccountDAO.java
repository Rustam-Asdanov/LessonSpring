package com.aop.spring_aop_order.dao;

import com.aop.spring_aop_order.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {


    public void addAccount(){
        System.out.println(getClass()+" Hello");
    }

    public void addAccount(Account theAcccout, String text){
        System.out.println(getClass()+"success add");
    }
}
