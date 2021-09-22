package com.hibernate.a2_one_to_one_bi_directional.example_udemy;

import com.hibernate.a2_one_to_one_bi_directional.example_udemy.model.InstructorDetail;
import com.hibernate.a2_one_to_one_bi_directional.example_udemy.repository.InstructorDetailRepository;
import com.hibernate.a2_one_to_one_bi_directional.example_udemy.repository.InstructorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GetInstructorDetailDemo {
    public static void main(String[] args){
        ConfigurableApplicationContext context = SpringApplication.run(GetInstructorDetailDemo.class);

        InstructorRepository instructorRepository =
                context.getBean("instructorRepository", InstructorRepository.class);

        InstructorDetailRepository instructorDetailRepository =
                context.getBean("instructorDetailRepository", InstructorDetailRepository.class);

        // get the instructor detail object

        int theId = 1;
        InstructorDetail tempInstructorDetail =
                instructorDetailRepository.findById(theId).get();

        // print the instructor detail

        System.out.println("tempInstructorDetail: " + tempInstructorDetail);

        // print the associated instructor

        System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

        System.out.println("Done!");

        context.close();
    }
}
