package com.hibernate.a3_one_to_many.uni.example_1;


import com.hibernate.a3_one_to_many.uni.example_1.controller.Players;
import com.hibernate.a3_one_to_many.uni.example_1.controller.Team;
import com.hibernate.a3_one_to_many.uni.example_1.repository.TeamRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class TestSpring {
    public static void main(String[] args){
        ConfigurableApplicationContext context = SpringApplication.run(TestSpring.class);

//        PlayersRepository playersRepository = context.getBean("playerRepository",PlayersRepository.class);
        TeamRepository teamRepository = context.getBean("teamRepository",TeamRepository.class);
        Players playerOne = new Players("Lionel","Messi","midfielder");
        Players playerTwo = new Players("JR","Neymar","striker");
        List<Players> playersList = new ArrayList<>();
        Collections.addAll(playersList,playerOne,playerTwo);
        Team teamOne = new Team("PSG","10 billion",playersList);
        teamRepository.save(teamOne);
        System.out.println("Success");
    }
}
