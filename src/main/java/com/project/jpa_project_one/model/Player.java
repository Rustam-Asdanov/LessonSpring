package com.project.jpa_project_one.model;

import javax.persistence.*;

@Entity
@Table(name = "player_project_one")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private int player_id;

    @Column(name = "full_name")
    private String full_name;

    @Column(name = "t_shirt_number")
    private String t_shirt_number;

    @Column(name = "position")
    private String position;

    @Column(name = "email")
    private String email;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "current_team")
    private Team current_team;

    public Player() {
    }

    public Player(String full_name, String t_shir_number, String position, String email) {
        this.full_name = full_name;
        this.t_shirt_number = t_shir_number;
        this.position = position;
        this.email = email;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getT_shirt_number() {
        return t_shirt_number;
    }

    public void setT_shirt_number(String t_shirt_number) {
        this.t_shirt_number = t_shirt_number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Team getTeam() {
        return current_team;
    }

    public void setTeam(Team current_team) {
        this.current_team = current_team;
    }

    @Override
    public String toString() {
        return "Player{" +
                "player_id=" + player_id +
                ", full_name='" + full_name + '\'' +
                ", t_shir_number='" + t_shirt_number + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", current_team=" + current_team +
                '}';
    }
}
