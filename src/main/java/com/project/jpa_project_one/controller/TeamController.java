package com.project.jpa_project_one.controller;

import com.project.jpa_project_one.model.Team;
import com.project.jpa_project_one.model.TeamDetail;
import com.project.jpa_project_one.repository.TeamDetailRepository;
import com.project.jpa_project_one.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamDetailRepository teamDetailRepository;

    @GetMapping
    public String getTeam(Model model){

        model.addAttribute("team", new Team());
        model.addAttribute("team_detail", new TeamDetail());

        return "/project/jpa_project_one/new_team";
    }

    @GetMapping("/addTeam")
    public String addTeam(
           @ModelAttribute("team") Team myTeam,
            @ModelAttribute("team_detail") TeamDetail teamDetail
    ){
//        myTeam.setTeamDetail(teamDetail);


        teamDetail.setTeam(myTeam);

        teamRepository.save(myTeam);

//        There is some bug when we try save throw detail
//        myTeam.setTeamDetail(teamDetail);
//
//
//        teamDetailRepository.save(teamDetail); // team does not see detail but detail see team


        System.out.println(myTeam);
        System.out.println(teamDetail);

        return "redirect:/team";
    }
}
