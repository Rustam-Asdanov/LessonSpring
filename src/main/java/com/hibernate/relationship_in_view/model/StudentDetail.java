package com.hibernate.relationship_in_view.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class StudentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String address;
    private String number;

    @OneToOne(mappedBy = "studentDetail")
    private Student student;

    public StudentDetail() {
    }

    public StudentDetail(String address, String number) {
        this.address = address;
        this.number = number;
    }
}
