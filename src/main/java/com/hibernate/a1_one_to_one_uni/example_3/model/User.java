package com.hibernate.a1_one_to_one_uni.example_3.model;

import javax.persistence.*;

@Entity
@Table(name = "user_one")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address_qil;

    public User() {
    }

    public User(String fullName) {
        this.fullName = fullName;
    }

    public User(String fullName, Address address) {
        this.fullName = fullName;
        this.address_qil = address;
    }

    public User(int id, String fullName, Address address) {
        this.id = id;
        this.fullName = fullName;
        this.address_qil = address;
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

    public Address getAddress() {
        return address_qil;
    }

    public void setAddress(Address address) {
        this.address_qil = address;
    }
}
