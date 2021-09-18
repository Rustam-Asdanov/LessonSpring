package com.project.jpa_project_one.model;

import javax.persistence.*;

@Entity
@Table(name = "team_detail_project_one")
public class TeamDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_detail_id")
    private int team_detail_id;
    @Column(name = "country")
    private String country;
    @Column(name = "city")
    private String city;
    @Column(name = "fund")
    private String fund;
    @Column(name = "president")
    private String president;

    @OneToOne(mappedBy = "teamDetail",cascade = CascadeType.ALL)
    private Team team;

    public TeamDetail() {
    }

    public TeamDetail(String country, String city, String fund, String president) {
        this.country = country;
        this.city = city;
        this.fund = fund;
        this.president = president;
    }

    public int getTeam_detail_id() {
        return team_detail_id;
    }

    public void setTeam_detail_id(int team_detail_id) {
        this.team_detail_id = team_detail_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFund() {
        return fund;
    }

    public void setFund(String fund) {
        this.fund = fund;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "TeamDetail{" +
                "team_detail_id=" + team_detail_id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", fund='" + fund + '\'' +
                ", president='" + president + '\'' +
                ", team=" + team +
                '}';
    }
}
