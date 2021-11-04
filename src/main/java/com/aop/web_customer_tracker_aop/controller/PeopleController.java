package com.aop.web_customer_tracker_aop.controller;

import com.aop.web_customer_tracker_aop.DAO.PeopleDAO;
import com.aop.web_customer_tracker_aop.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/page")
public class PeopleController {

    @Autowired
    private PeopleDAO peopleDAO;



    private static int theId;

    @RequestMapping
    public String getPage(Model model){
        model.addAttribute("people", new People());

        return "/example_validation/main";
    }

    @RequestMapping("/add")
    public String addPeople(@ModelAttribute People people){
        peopleDAO.addPeople(people);

        char first = people.getFullName().charAt(0);

        if(first>='A' && first<='H'){
            System.out.println("A-H");
        }




        return "redirect:/page";
    }

    @RequestMapping("/showBase")
    public String showBase(Model model){
        model.addAttribute("peopleList",peopleDAO.getPeopleList());

        return "/example_validation/base";
    }


    @RequestMapping("/delete/{id}")
    public String deleteElement(@PathVariable("id") int id){
        System.out.println(id);

        peopleDAO.deleteElem(theId);

        return "redirect:/page";
    }

    @RequestMapping("/edit/{id}")
    public String editElement(@PathVariable("id") int id, Model model){
        System.out.println(id);

        theId = id-1;

        model.addAttribute("people",peopleDAO.getPeople(theId));


        return "/example_validation/main";
    }

    @RequestMapping("/save")
    public String saveFunction(
            @ModelAttribute(name="people") People thePeople
    ){


        System.out.println(thePeople.getFullName());
        peopleDAO.savePeople(thePeople,theId);

        return "redirect:/page/showBase";
    }
}
