package com.hibernate.relationship_in_view.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;

    @OneToMany
    @JoinColumn(name = "student_detail_id")
    private StudentDetail studentDetail;

    @ManyToMany(fetch = FetchType.LAZY, cascade =
            {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name = "student_lessons",
            joinColumns = @JoinColumn(name="student_id"),
            inverseJoinColumns = @JoinColumn(name = "lessons_id")
    )
    private List<Lessons> lessonsList;

    public Student() {
    }

    public Student(String fullName) {
        this.fullName = fullName;
    }

    public void addLessons(Lessons theLesson){
        if(lessonsList == null){
            lessonsList = new ArrayList<>();
        }

        lessonsList.add(theLesson);
    }
}
