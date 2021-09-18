package com.project.jpa_project_one.controller;

import com.project.jpa_project_one.model.Team;
import com.project.jpa_project_one.model.TeamDetail;
import com.project.jpa_project_one.repository.TeamRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/team")
public class TeamController {

    private TeamRepository teamRepository;

    @GetMapping
    public String getTeam(Model model){

        model.addAttribute("team", Team.class);
        model.addAttribute("team_detail", TeamDetail.class);

        return "/project/jpa_project_one/new_team";
    }

    @GetMapping("/addTeam")
    public String addTeam(){



        return "redirect:/team";
    }
}
