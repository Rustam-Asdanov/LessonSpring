package com.king.exampleHibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication {
    public static void main(String[] args){
        SpringApplication.run(WebApplication.class);
        System.out.println("run!");
    }
}
