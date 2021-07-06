package com.king.exampleCRUD2.controllers;

import com.king.exampleCRUD2.dao.HumansDAO;
import com.king.exampleCRUD2.models.Humans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HumanController {

    @Autowired
    private HumansDAO humansDAO;

    @GetMapping()
    public String getMain(Model model){
        model.addAttribute("human", new Humans());

        return "human/main";
    }

    @GetMapping("/result")
    public String getResult(
            @ModelAttribute Humans humans,
            Model model
    ){

        humansDAO.insert(humans);

        model.addAttribute("human",humansDAO.getData());

        return "human/result";
    }

}
