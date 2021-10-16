package com.aop.spring_demo_app_two.DAO;

import com.aop.spring_demo_app_two.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    public void addAccount(Account theAccount, boolean isExt){
        System.out.println(getClass()+" : doing my Db work: adding an account" );
    }
}
