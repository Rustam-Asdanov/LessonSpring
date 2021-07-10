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
    private String country;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="human_orders")
    private Orders human_orders;

    public Human() {
    }

    public Human(String name, String country, Orders human_orders) {
        this.name = name;
        this.country = country;
        this.human_orders = human_orders;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Orders getHuman_orders() {
        return human_orders;
    }

    public void setHuman_orders(Orders human_orders) {
        this.human_orders = human_orders;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", human_orders=" + human_orders +
                '}';
    }
}
