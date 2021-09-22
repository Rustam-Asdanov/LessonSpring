package com.hibernate.a4_many_to_many.uni.example_udemy;

import com.hibernate.a4_many_to_many.uni.example_udemy.model.Student;
import com.hibernate.a4_many_to_many.uni.example_udemy.model.Course;
import com.hibernate.a4_many_to_many.uni.example_udemy.repository.CourseRepository;
import com.hibernate.a4_many_to_many.uni.example_udemy.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CreateCourseAndStudentsDemo {
    public static void main(String[] args){
        ConfigurableApplicationContext context =
                SpringApplication.run(CreateCourseAndStudentsDemo.class);

        CourseRepository courseRepository =
                context.getBean("courseRepository", CourseRepository.class);

        StudentRepository studentRepository =
                context.getBean("studentRepository", StudentRepository.class);

        // create the course
        Course tempCourse = new Course("Pacman - how to score one million points");



        // create the students
        Student tempStudent1 = new Student("Xuliqan Qaduyev");
        Student tempStudent2 = new Student("Amish Xalashov");

        // add students to the course
        tempCourse.addStudent(tempStudent1);
        tempCourse.addStudent(tempStudent2);

        // save the students
        System.out.println("\nSaving students ...");
        studentRepository.save(tempStudent1);
        studentRepository.save(tempStudent2);
        System.out.println("Saved students: " + tempCourse.getStudents());

        // save the course
        System.out.println("\nSaving the course...");
        courseRepository.save(tempCourse);
        System.out.println("Saved the course: " + tempCourse);

        System.out.println("Success");
        context.close();
    }
}
