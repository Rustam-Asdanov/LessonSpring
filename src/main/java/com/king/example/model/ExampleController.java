package com.king.example.model;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @GetMapping("/fetchRequest")
    public ExampleModel returnResult(Model model){
        return new ExampleModel("Vasya", 19);
    }
}
