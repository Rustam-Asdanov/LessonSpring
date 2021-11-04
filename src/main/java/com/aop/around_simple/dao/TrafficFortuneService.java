package com.aop.around_simple.dao;

import com.aop.around_simple.model.Account;

import java.util.ArrayList;
import java.util.List;

public class TrafficFortuneService {

    // add a new method: findAccounts()

    public List<Account> findAccounts(boolean tripWire){

//        System.out.println("I am here");

        if(tripWire){
            throw new RuntimeException("No soup for you!!!");
        }

        List<Account> myAccounts = new ArrayList<>();

        // create sample accounts
        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Madhu", "Platinum");
        Account temp3 = new Account("Luca","Gold");

        // add them to our accounts list
        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;
    }
}
