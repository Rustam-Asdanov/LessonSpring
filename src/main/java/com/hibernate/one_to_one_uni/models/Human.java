package com.hibernate.one_to_one_uni.models;

import javax.persistence.*;

@Entity
@Table(name="human")
public class Human {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="country")
    public String city;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="human_orders")
    private Orders human_orders;

    public Human() {
    }

    public Human(String name, String city) {
        this.name = name;
        this.city = city;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Orders getHuman_orders() {
        return human_orders;
    }

    public void setHuman_orders(Orders human_orders) {
        this.human_orders = human_orders;
    }
}
