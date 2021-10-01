package com.hibernate.relationship_in_view.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Table
public class Teacher {

    {
        System.out.println("teacher");
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
    private String proficiency;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Lessons> lessonsList;

    public Teacher() {
    }

    public Teacher(String fullName, String proficiency) {
        this.fullName = fullName;
        this.proficiency = proficiency;
    }

    public void addLesson(Lessons theLesson){
        if(lessonsList==null){
            lessonsList = new ArrayList<>();
        }

        theLesson.setTheTeacher(this);
        lessonsList.add(theLesson);
    }
}
