package com.aop.spring_demo_app_three.DAO;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public void addAccount(int text){
        System.out.println(getClass() + " : Doing my work: adding an account");
    }

    public void removeAccount(){
        System.out.println("We want to remove this account");
    }

    public String getName() {
        System.out.println(getClass() + " : getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " : setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " : getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " : setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
