package com.king.example_by_id.model;

public class People {

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
}
