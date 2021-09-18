package com.project.jpa_project_one.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/start")
public class StartController {

    @GetMapping
    public String getMainPage(){
        return "/project/jpa_project_one/start";
    }
}
