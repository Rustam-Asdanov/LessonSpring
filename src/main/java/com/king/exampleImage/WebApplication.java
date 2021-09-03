package com.king.exampleImage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan("com.king.exampleImage")
public class WebApplication {
    public static void main(String[] args){
        SpringApplication.run(WebApplication.class);
    }
}
