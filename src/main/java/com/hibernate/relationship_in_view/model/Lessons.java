package com.hibernate.relationship_in_view.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
public class Lessons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String topic;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private Teacher theTeacher;

    @ManyToMany(fetch = FetchType.LAZY, cascade =
            {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name = "student_lessons",
            joinColumns = @JoinColumn(name = "lessons_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> studentList;

    public Lessons() {
    }

    public Lessons(String topic) {
        this.topic = topic;
    }

    public void addStudent(Student theStudent){
        if(studentList == null){
            studentList = new ArrayList<>();
        }

        studentList.add(theStudent);
    }
}
