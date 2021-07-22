package com.king.examplecrUD4.Controller;

import com.king.examplecrUD4.DAO.PersonDAO;
import com.king.examplecrUD4.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/crud4")
public class PersonController {

    @Autowired
    private PersonDAO personDAO;

    @GetMapping()
    public String start(Model model){
        model.addAttribute("person", new Person());

        return "exampleCRUD4/main";
    }

    @PostMapping()
    public String insert(@ModelAttribute("person") Person person){
        personDAO.insertPerson(person);
        return "redirect:/crud4";
    }

    @GetMapping("/showTable")
    public String showTable(Model model){
        model.addAttribute("peopleList", personDAO.getPeopleData());

        return "exampleCRUD4/result";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        System.out.println(id);
        model.addAttribute("person", personDAO.getPerson(id));

        return "exampleCRUD4/edit";
    }

    @GetMapping("/{id}")
    public String update(@ModelAttribute("person") Person person){
        personDAO.update(person);

        return "redirect:/crud4";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id){
        personDAO.delete(id);

        return "redirect:/crud4/showTable";
    }
}
