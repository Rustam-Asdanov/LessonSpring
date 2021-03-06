package com.hibernate.a5_eager_vs_lazy.bi.example_udemy.model;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
@Transactional
public class Instructor {

    /**
     * -----Instructions-----
     *
     *      annotate the class as an entity and map to db table
     *
     *      define the fields
     *
     *      annotate the fields with db column names
     *
     *      ** set up mapping to InstructorDetail entity
     *
     *      create constructors
     *
     *      generate getter/setter methods
     *
     *      generate toString() method
     *
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instructor_id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetail instructorDetail;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "instructor",
                cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Course> courses;

    public Instructor() {
    }

    // Start of first type

    public Instructor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // end of first type

    // second type

    public Instructor(String firstName, String lastName, String email, InstructorDetail instructorDetail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.instructorDetail = instructorDetail;
    }

    // end of second type


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InstructorDetail getInstructorDetail() {
        return instructorDetail;
    }

    public void setInstructorDetail(InstructorDetail instructorDetail) {
        this.instructorDetail = instructorDetail;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", instructorDetail=" + instructorDetail +
                '}';
    }

    // add convenience methods for bi-directional relationship

    /*
    for example we crate new course and add to this instructor
     */
    public void addCourse(Course tempCourse){

        if(courses == null){
            courses = new ArrayList<>();
        }

        courses.add(tempCourse);

        tempCourse.setInstructor(this);
    }
}
