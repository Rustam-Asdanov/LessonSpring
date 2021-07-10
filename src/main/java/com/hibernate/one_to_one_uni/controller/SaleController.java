package com.hibernate.one_to_one_uni.controller;

import com.hibernate.one_to_one_uni.models.Human;
import com.hibernate.one_to_one_uni.models.Orders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/oneToOne")
public class SaleController {

    @GetMapping()
    public String getMainPage(Model model){
        return "hibernate/one-to-one-uni/main";
    }

    @GetMapping("/showResult")
    public String getResult(
            @ModelAttribute Human human,
            @ModelAttribute Orders orders,
            Model model){
        model.addAttribute("humanList");
        model.addAttribute("orderList");

        return "hibernate/one-to-one-uni/result";
    }
}