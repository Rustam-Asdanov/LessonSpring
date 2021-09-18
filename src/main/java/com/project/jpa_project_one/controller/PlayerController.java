package com.project.jpa_project_one.controller;

import com.project.jpa_project_one.model.Player;
import com.project.jpa_project_one.model.Team;
import com.project.jpa_project_one.repository.PlayerRepository;
import com.project.jpa_project_one.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping
    public String getPlayer(Model model){

        List<Team> teamList = teamRepository.findAll();

        model.addAttribute("team_name", "");
        model.addAttribute("teamList", teamList);
        model.addAttribute("player", new Player());


        return "/project/jpa_project_one/new_player";
    }

    @PostMapping("/addPlayer")
    public String addPlayer(
            @ModelAttribute("team_name") String teamName,
            @ModelAttribute("player") Player player
    ){
        System.out.println("Hey : "+teamName);

        List<Player> playerList = new ArrayList<>();
        playerList.add(player);
//        myTeam.setPlayerList(playerList);

//        teamRepository.save(myTeam);

        return "redirect:/player";
    }
}
