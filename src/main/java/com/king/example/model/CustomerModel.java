package com.king.example.model;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerModel {

    @GetMapping("/fetchRequest")
    public Model returnResult(Model model){

        model.addAttribute("name", "Mamed");

        return model;
    }
}
