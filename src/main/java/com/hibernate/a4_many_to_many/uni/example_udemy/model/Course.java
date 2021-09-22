package com.hibernate.a4_many_to_many.uni.example_udemy.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    /**
     *
     * ------Instruction------
     *
     *      define our fields
     *
     *      define constructors
     *
     *      define getter setters
     *
     *      define toString
     *
     *      annotate fields
     *
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "instr_id")
    private Instructor instructor;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "cor_id")
    private List<Review> reviews;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REFRESH,CascadeType.DETACH})
    @JoinTable(
        name = "course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> studentList;

    public Course() {
    }

    public Course(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Student> getStudents() {
        return studentList;
    }

    public void setStudents(List<Student> students) {
        this.studentList = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", instructor=" + instructor +
                '}';
    }

    public void addReview(Review theReview){

        if(reviews == null){
            reviews = new ArrayList<>();
        }

        reviews.add(theReview);
    }

    // add single student
    public void addStudent(Student theStudent){
        if(studentList == null){
            studentList = new ArrayList<>();
        }

        studentList.add(theStudent);
    }
}
