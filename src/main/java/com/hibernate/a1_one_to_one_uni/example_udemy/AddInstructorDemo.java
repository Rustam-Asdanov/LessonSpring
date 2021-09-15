package com.hibernate.a1_one_to_one_uni.example_udemy;

import com.hibernate.a1_one_to_one_uni.example_udemy.model.Instructor;
import com.hibernate.a1_one_to_one_uni.example_udemy.model.InstructorDetail;
import com.hibernate.a1_one_to_one_uni.example_udemy.repository.InstructorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AddInstructorDemo {
    public static void main(String[] args){
        ConfigurableApplicationContext context = SpringApplication.run(AddInstructorDemo.class);

        InstructorRepository instructorRepository =
                context.getBean("instructorRepository", InstructorRepository.class);

        // create the objects

        /*
        Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
        InstructorDetail tempInstructorDetail = new InstructorDetail(
                "http://www.luv2code.com/youtube",
                "Luv 2 code!!!");
        */

        Instructor tempInstructor = new Instructor("David", "Beckham", "david@luv2code.com");
        InstructorDetail tempInstructorDetail = new InstructorDetail(
                "http://www.luv2code.com",
                "Play football!!!");

        // associate the objects

        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // save the instructor

        System.out.println("Saving instructor: " + tempInstructor);

        instructorRepository.save(tempInstructor);

        System.out.println("Done!");

        context.close();
    }
}
