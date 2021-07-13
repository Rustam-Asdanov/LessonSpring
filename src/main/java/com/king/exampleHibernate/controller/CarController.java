package com.king.exampleHibernate.controller;

import com.king.exampleHibernate.model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/car")
public class CarController {

    @GetMapping()
    public String getForm(
            Model model
    ){
        model.addAttribute("myCar",new Car());

        return "exampleHibernate/main";
    }

    @PostMapping("/insert")
    public String insertData(
            @ModelAttribute Car myCar
    ){
        return "redirect:/car";
    }
}
