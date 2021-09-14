package com.hibernate.a1_one_to_one_uni.example_3.model;

import javax.persistence.*;

@Entity
@Table(name = "address_one")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String city;
    private String district;
    private String street;

    @OneToOne(mappedBy = "address_qil")
    private User user;


    public Address() {
    }

    public Address(String city, String district, String street) {
        this.city = city;
        this.district = district;
        this.street = street;
    }

    public Address(int id, String city, String district, String street, User user) {
        this.id = id;
        this.city = city;
        this.district = district;
        this.street = street;
        this.user = user;
    }

    public Address(String city, String district, String street, User user) {
        this.city = city;
        this.district = district;
        this.street = street;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
