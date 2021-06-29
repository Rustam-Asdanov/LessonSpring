package com.king.example.controllers;

import com.king.example.data.Customer;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/")
    public String showMainPage(){
        return "main";
    }

    @GetMapping("/showForm")
    public String showForm(Model model){

        model.addAttribute("customer", new Customer());


        return "customer-form";
    }

    @GetMapping("/showResult")
    public String showResult(
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult
    ){

        System.out.println("Binding result: " + bindingResult);
        if(bindingResult.hasErrors()){
            return "customer-form";
        } else {
            return "result";
        }
    }
}
