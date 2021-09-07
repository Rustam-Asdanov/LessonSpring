package com.king.exampleAnnotation;

import org.springframework.stereotype.Component;

@Component("myLaptop")
public class Laptop implements Technology{
    @Override
    public String getTypeName() {
        return "Acer Nitro 5";
    }
}
