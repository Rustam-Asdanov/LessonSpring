package com.king.examplecrUD4.Controller;

import com.king.examplecrUD4.Model.Person;
import com.king.examplecrUD4.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/crud4")
public class PersonControllerTwo {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping()
    public String start(Model model){
        model.addAttribute("person", new Person());

        return "exampleCRUD4/main";
    }

    @PostMapping()
    public String insert(@ModelAttribute("person") Person person){
//        personDAO.insertPerson(person);
        personRepository.save(person);
        return "redirect:/crud4";
    }

    @GetMapping("/showTable")
    public String showTable(Model model){
//        model.addAttribute("peopleList", personDAO.getPeopleData());
        model.addAttribute("peopleList",personRepository.findAll());
        return "exampleCRUD4/result";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        System.out.println(id);
        model.addAttribute("id",id);
//        model.addAttribute("person", personDAO.getPerson(id));

        model.addAttribute("person",personRepository.getById(id));

        return "exampleCRUD4/edit";
    }

    @GetMapping("/{id}")
    public String update(@ModelAttribute("person") Person person, @PathVariable("id") int id){
        System.out.println(id);
//        personDAO.update(id,person);

        personRepository.save(person);

        return "redirect:/crud4";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id){
//        personDAO.delete(id);
        personRepository.deleteById(id);
        return "redirect:/crud4/showTable";
    }
}
