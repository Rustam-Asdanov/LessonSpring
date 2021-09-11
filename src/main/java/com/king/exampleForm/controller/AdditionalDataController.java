package com.king.exampleForm.controller;

import com.king.exampleForm.model.AdditionalData;
import com.king.exampleForm.repository.AdditionalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/exampleFormer")
public class AdditionalDataController {

    @Autowired
    private AdditionalDataRepository addRepository;

    @GetMapping
    private String getPage(){
        return "exampleForms/mainFormOne";
    }

    @GetMapping("/addOne")
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

    @GetMapping("/formTwo")
    public String getPageTwo(Model model){
        System.out.println("Start");
        model.addAttribute("extra", new AdditionalData());
        System.out.println("Continue");
        return "exampleForms/mainFormTwo";
    }

    @GetMapping("/addTwo")
    private String getMainTwo(
            @ModelAttribute("extraData") AdditionalData additionalData
    ){
        System.out.println(additionalData.getCity());
        addRepository.save(additionalData);

        return "redirect:/exampleFormer/formTwo";
    }
}
