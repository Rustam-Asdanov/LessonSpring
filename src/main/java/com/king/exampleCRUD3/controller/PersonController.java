package com.king.exampleCRUD3.controller;

import com.king.exampleCRUD3.DAO.PersonDAO;
import com.king.exampleCRUD3.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personNew")
public class PersonController {

    @Autowired
    private PersonDAO personDAO;

    @GetMapping()
    public String index(Model model){
        model.addAttribute("people", new Person());
        return "exampleCRUD3/show";
    }

    @GetMapping("/update/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personDAO.getPerson(id));
        return "exampleCRUD3/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person){
        personDAO.insert(person);

        return "exampleCRUD3/new";
    }

    @GetMapping("/showList")
    public String showList(Model model){
        model.addAttribute("peopleList", personDAO.getData());
        return "exampleCRUD3/indexs";
    }

}


