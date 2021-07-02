package com.king.example.model;

import com.king.example.data.Customer;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

@RestController
public class CustomerModel {

    @GetMapping("/fetchRequest")
    public Customer returnResult(Model modelOne){

//        modelOne.addAttribute("name", "Mamed");

        return new Customer("Vasya");
    }
}
