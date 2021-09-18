package com.project.jpa_project_one.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/player")
public class PlayerController {

    @GetMapping
    public String getPlayer(){
        return "/project/jpa_project_one/new_player";
    }
}
