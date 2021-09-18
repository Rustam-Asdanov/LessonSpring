package com.project.jpa_project_one.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "team_project_one")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private int team_id;

    @Column(name = "team_name")
    private String team_name;

    @Column(name = "team_logo")
    private String team_logo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id")
    private TeamDetail teamDetail;

    @OneToMany(mappedBy = "current_team", cascade = CascadeType.ALL)
    private List<Player> playerList;

    public Team() {
    }

    public Team(String team_name, String team_logo) {
        this.team_name = team_name;
        this.team_logo = team_logo;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getTeam_logo() {
        return team_logo;
    }

    public void setTeam_logo(String team_logo) {
        this.team_logo = team_logo;
    }

    public TeamDetail getTeamDetail() {
        return teamDetail;
    }

    public void setTeamDetail(TeamDetail teamDetail) {
        this.teamDetail = teamDetail;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    @Override
    public String toString() {
        return "Team{" +
                "team_id=" + team_id +
                ", team_name='" + team_name + '\'' +
                ", team_logo='" + team_logo + '\'' +
                ", teamDetail=" + teamDetail +
                ", playerList=" + playerList +
                '}';
    }

    public void addPlayer(Player thePlayer){
        if(playerList == null){
            playerList = new ArrayList<>();
        }

        playerList.add(thePlayer);

        thePlayer.setTeam(this);
    }
}
