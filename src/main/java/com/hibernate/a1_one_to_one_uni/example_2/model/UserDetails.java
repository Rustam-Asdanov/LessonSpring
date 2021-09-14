package com.hibernate.a1_one_to_one_uni.example_2.model;

import javax.persistence.*;

@Entity
@Table(name = "user_details_one_to_one")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "address")
    private String address;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "educationDegree")
    private String educationDegree;

    @OneToOne(mappedBy = "")
    private String user_id;

    public UserDetails() {
    }

    public UserDetails(String address, String birthday, String educationDegree) {
        this.address = address;
        this.birthday = birthday;
        this.educationDegree = educationDegree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(String educationDegree) {
        this.educationDegree = educationDegree;
    }
}
