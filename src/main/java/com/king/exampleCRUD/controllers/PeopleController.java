package com.king.exampleCRUD.controllers;

import com.king.exampleCRUD.dao.PersonDAO;
import com.king.exampleCRUD.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model){
        // We get all people from dao and send it to view
        model.addAttribute("people", personDAO.index());
        return "people/indexs";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){

        // we get one person from DAO with ID and send it to view

        model.addAttribute("person",personDAO.show(id));

        return "people/show";
    }

    @GetMapping("/info")
    public String getParam(HttpServletRequest request){
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println(name+ " " + surname);

        return "people/indexs";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable int id){
        model.addAttribute("person", personDAO.show(id));

        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(
            @ModelAttribute("person") Person person,
            @PathVariable("id") int id
    ){
//        personDAO.update(id,person);
//
        return "redirect:/people";
    }
}
