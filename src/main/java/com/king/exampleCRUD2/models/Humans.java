package com.king.exampleCRUD2.models;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Humans {

    private int id;
    @NotEmpty(message="please input your name")
    @Size(min=2, max=20, message="name should contain at least 2 letters")
    private String name;
    @NotEmpty(message="please input your surname")
    @Size(min=2, max=20, message="surname should contain at least 2 letters")
    private String surname;
    @Email(message="invalid email address format")
    private String email;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
