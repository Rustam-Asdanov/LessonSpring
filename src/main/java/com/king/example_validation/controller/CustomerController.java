package com.king.example_validation.controller;

import com.king.example_validation.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping
    public String getPage(Model model){

        model.addAttribute("theCustomer", new Customer());

        return "/example_validation_new/main";
    }

    @GetMapping("/add")
    public String addCustomer(
            @Valid @ModelAttribute(name = "theCustomer") Customer theCustomer,
            BindingResult bindingResult
    ){

        System.out.println("binding result: " + bindingResult);

        if(bindingResult.hasErrors()){
            return "/example_validation_new/main";
        }
        return "redirect:/customer";
    }

}
