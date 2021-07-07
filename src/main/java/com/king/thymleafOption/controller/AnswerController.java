package com.king.thymleafOption.controller;

import com.king.thymleafOption.model.Answer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/option")
public class AnswerController {

    @GetMapping("/getForm")
    public String getMain(
            Model model
    ){
        model.addAttribute("answer", new Answer());

        return "thymleafOption/optionMain";
    }

    @GetMapping("/getResult")
    public String getResult(
            @ModelAttribute Answer answer,
            Model model
    ){
        model.addAttribute("resultList", answer.getAnswerList());

        return "thymleafOption/result";
    }
}
