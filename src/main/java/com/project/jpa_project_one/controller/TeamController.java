package com.project.jpa_project_one.controller;

import com.project.jpa_project_one.model.Team;
import com.project.jpa_project_one.model.TeamDetail;
import com.project.jpa_project_one.repository.TeamRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/team")
public class TeamController {

    private TeamRepository teamRepository;

    @GetMapping
    public String getTeam(Model model){

        model.addAttribute("team", new Team());
        model.addAttribute("team_detail", new TeamDetail());

        return "/project/jpa_project_one/new_team";
    }

    @GetMapping("/addTeam")
    public String addTeam(
            @RequestParam(name = "team") Team myTeam,
            @RequestParam(name = "team_detail") TeamDetail teamDetail
    ){

        System.out.println(myTeam);
        System.out.println(teamDetail);

        myTeam.setTeamDetail(teamDetail);
        teamRepository.save(myTeam);

        return "redirect:/team";
    }
}
