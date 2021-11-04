package com.aop.web_customer_tracker_aop.model;

import javax.persistence.*;

@Entity
@Table
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
    private String country;
    private String number;

    public People() {
    }

    public People(int id, String fullName, String country, String number) {
        this.id = id;
        this.fullName = fullName;
        this.country = country;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", country='" + country + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
