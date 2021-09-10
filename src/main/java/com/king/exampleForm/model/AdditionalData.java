package com.king.exampleForm.model;

import javax.persistence.*;

@Entity
@Table(name="example_form")
public class AdditionalData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "sex")
    private String sex;

    @Column(name = "language")
    private String language;

    @Column(name = "city")
    private String city;

    @Column(name = "note")
    private String note;

    public AdditionalData() {
    }

    public AdditionalData(String fullName, String sex, String language, String city, String note) {
        this.fullName = fullName;
        this.sex = sex;
        this.language = language;
        this.city = city;
        this.note = note;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
