package com.hibernate.a3_one_to_many.bi.example_udemy;

import com.hibernate.a3_one_to_many.bi.example_udemy.model.Course;
import com.hibernate.a3_one_to_many.bi.example_udemy.model.Instructor;
import com.hibernate.a3_one_to_many.bi.example_udemy.repository.CourseRepository;
import com.hibernate.a3_one_to_many.bi.example_udemy.repository.InstructorDetailRepository;
import com.hibernate.a3_one_to_many.bi.example_udemy.repository.InstructorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GetInstructorCoursesDemo {
    public static void main(String[] args){
        ConfigurableApplicationContext context =
                SpringApplication.run(GetInstructorCoursesDemo.class);

        InstructorRepository instructorRepository =
                context.getBean("instructorRepository", InstructorRepository.class);

        InstructorDetailRepository instructorDetailRepository =
                context.getBean("instructorDetailRepository", InstructorDetailRepository.class);

        CourseRepository courseRepository =
                context.getBean("courseRepository", CourseRepository.class);

        // get the instructor from db

        int theId=1;
        Instructor tempInstructor = instructorRepository.findById(1).get();

        System.out.println("Instructor: " + tempInstructor);

        // get courses for instructor
        System.out.println("Courses: " + tempInstructor.getCourses());


        System.out.println("Success");
        context.close();
    }
}
