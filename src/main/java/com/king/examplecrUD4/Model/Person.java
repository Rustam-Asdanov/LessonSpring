package com.king.examplecrUD4.Model;

public class Person {
    private int id;

    private String name;

    private String coutnry;

    public Person(){}

    public Person(String name, String coutnry) {
        this.name = name;
        this.coutnry = coutnry;
    }

    public Person(int id, String name, String coutnry) {
        this.id = id;
        this.name = name;
        this.coutnry = coutnry;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoutnry() {
        return coutnry;
    }

    public void setCoutnry(String coutnry) {
        this.coutnry = coutnry;
    }
}
