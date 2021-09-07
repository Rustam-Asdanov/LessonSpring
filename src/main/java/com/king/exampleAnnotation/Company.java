package com.king.exampleAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("com")
public class Company {
    @Autowired
    @Qualifier("myLaptop")
    private Technology technology;


    public void getProduct(){
        System.out.println(technology.getTypeName());
    }
}
