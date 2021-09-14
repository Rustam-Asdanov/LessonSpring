package com.hibernate.a3_one_to_many.controller;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "team_ont_to_many")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String teamName;
    private String teamFund;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "players_id")
    private List<Players> players;

    public Team() {
    }

    public Team(String teamName, String teamFund, List<Players> players) {
        this.teamName = teamName;
        this.teamFund = teamFund;
        this.players = players;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamFund() {
        return teamFund;
    }

    public void setTeamFund(String teamFund) {
        this.teamFund = teamFund;
    }

    public List<Players> getPlayers() {
        return players;
    }

    public void setPlayers(List<Players> players) {
        this.players = players;
    }
}
