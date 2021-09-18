package com.project.jpa_project_one.model;

import javax.persistence.*;

@Entity
@Table(name = "team_project_one")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int team_id;
    private String team_name;
    private String team_logo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id")
    private TeamDetail teamDetail;

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
}
