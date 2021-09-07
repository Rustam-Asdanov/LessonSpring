package com.king.exampleAnnotation;

import org.springframework.stereotype.Component;

@Component("smartphone")
public class Smartphone implements Technology{
    @Override
    public String getTypeName() {
        return "Iphone X";
    }
}
