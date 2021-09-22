package com.hibernate.a4_many_to_many.uni.example_udemy;

import com.hibernate.a4_many_to_many.uni.example_udemy.model.Course;
import com.hibernate.a4_many_to_many.uni.example_udemy.model.Instructor;
import com.hibernate.a4_many_to_many.uni.example_udemy.repository.CourseRepository;
import com.hibernate.a4_many_to_many.uni.example_udemy.repository.InstructorDetailRepository;
import com.hibernate.a4_many_to_many.uni.example_udemy.repository.InstructorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CreateCoursesDemo {
    public static void main(String[] args){
        ConfigurableApplicationContext context =
                SpringApplication.run(CreateCoursesDemo.class);

        InstructorRepository instructorRepository =
                context.getBean("instructorRepository", InstructorRepository.class);

        InstructorDetailRepository instructorDetailRepository =
                context.getBean("instructorDetailRepository", InstructorDetailRepository.class);

        CourseRepository courseRepository =
                context.getBean("courseRepository", CourseRepository.class);

        // get the instructor from db

        int theId=4;
        Instructor tempInstructor = instructorRepository.findById(theId).get();

        // create some courses

        Course tempCourse1 = new Course("Taekwandoo");
        Course tempCourse2 = new Course("Be first");

        // add courses to instructor

        tempInstructor.addCourse(tempCourse1);
        tempInstructor.addCourse(tempCourse2);

        // save the courses

        courseRepository.save(tempCourse1);
        courseRepository.save(tempCourse2);

        System.out.println("Success");
        context.close();
    }
}
