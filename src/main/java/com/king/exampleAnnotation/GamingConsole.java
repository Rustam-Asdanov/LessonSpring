package com.king.exampleAnnotation;

import org.springframework.stereotype.Component;

@Component("gameCons")
public class GamingConsole implements Technology{
    @Override
    public String getTypeName() {
        return "PlayStation 5";
    }
}
