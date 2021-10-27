package com.aop.spring_demo_app_three.DAO;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public boolean addSillyMember(){
        System.out.println(getClass() + " Doing stuff");

        return true;
    }

    public void goToSleep(){
        System.out.println(getClass() + " I am going to sleep");
    }
}
