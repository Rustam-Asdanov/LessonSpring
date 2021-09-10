package com.king.exampleForm.controller;

import com.king.exampleForm.model.AdditionalData;
import com.king.exampleForm.repository.AdditionalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/exampleForm")
public class AdditionalDataController {

    @Autowired
    private AdditionalDataRepository addRepository;

    @GetMapping
    private String getPage(){
        return "exampleForms/mainForms";
    }

    @GetMapping("/add")
    public String getMain(
            @RequestParam(name = "fullName") String name,
            @RequestParam(name = "sex") String sex,
            @RequestParam(name = "language") String language,
            @RequestParam(name = "cities") String cities,
            @RequestParam(name = "note") String note
    ){
        System.out.println(name+ " "+ sex + " " + language+
                " " + cities + " " + note);
        addRepository.save(new AdditionalData(
                name,sex,language,cities,note
        ));

        return "redirect:/exampleForm";
    }
}
