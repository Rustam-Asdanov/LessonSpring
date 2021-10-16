package com.king.example_validation.controller;

import com.king.example_validation.DAO.PeopleDAO;
import com.king.example_validation.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/page")
public class PeopleController {

    @Autowired
    private PeopleDAO peopleDAO;

    @RequestMapping
    public String getPage(Model model){
        model.addAttribute("people", new People());

        return "/example_validation/main";
    }

    @RequestMapping("/add")
    public String addPeople(@ModelAttribute People people){
        peopleDAO.addPeople(people);

        return "redirect:/page";
    }

    @RequestMapping("/showBase")
    public String showBase(Model model){
        model.addAttribute("peopleList",peopleDAO.getPeopleList());

        return "/example_validation/base";
    }

}
