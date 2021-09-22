package com.hibernate.a4_many_to_many.uni.example_udemy;

import com.hibernate.a4_many_to_many.uni.example_udemy.model.Instructor;
import com.hibernate.a4_many_to_many.uni.example_udemy.model.InstructorDetail;
import com.hibernate.a4_many_to_many.uni.example_udemy.repository.CourseRepository;
import com.hibernate.a4_many_to_many.uni.example_udemy.repository.InstructorDetailRepository;
import com.hibernate.a4_many_to_many.uni.example_udemy.repository.InstructorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CreateInstructorDemo {
    public static void main(String[] args){
        ConfigurableApplicationContext context =
                SpringApplication.run(CreateInstructorDemo.class);

        InstructorRepository instructorRepository =
                context.getBean("instructorRepository", InstructorRepository.class);

        InstructorDetailRepository instructorDetailRepository =
                context.getBean("instructorDetailRepository", InstructorDetailRepository.class);

        CourseRepository courseRepository =
                context.getBean("courseRepository", CourseRepository.class);

        // create objects
        Instructor tempInstructor =
                new Instructor("Zlatan","Ibrahimovic","ibra@gmail.com");

        InstructorDetail tempInstructorDetail =
                new InstructorDetail("http://www.youtube.com/gomez","Taekwando");

        tempInstructor.setInstructorDetail(tempInstructorDetail);
        instructorRepository.save(tempInstructor);

        System.out.println("Success");
        context.close();
    }
}
