package com.hibernate.a2_one_to_one_bi_directional.example_udemy;

import com.hibernate.a2_one_to_one_bi_directional.example_udemy.model.Instructor;
import com.hibernate.a2_one_to_one_bi_directional.example_udemy.model.InstructorDetail;
import com.hibernate.a2_one_to_one_bi_directional.example_udemy.repository.InstructorDetailRepository;
import com.hibernate.a2_one_to_one_bi_directional.example_udemy.repository.InstructorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class UpdateInstructorDemo {
    public static void main(String[] args){
        ConfigurableApplicationContext context =
                SpringApplication.run(UpdateInstructorDemo.class);

        InstructorRepository tempInstructorRepository =
                context.getBean("instructorRepository", InstructorRepository.class);

        InstructorDetailRepository instructorDetailRepository =
                context.getBean("instructorDetailRepository", InstructorDetailRepository.class);

        InstructorDetail tempInstructorDetail =
                new InstructorDetail("rutube.com","play darts");

        Instructor tempInstructor = tempInstructorRepository.findById(3).get();

        System.out.println("We get instructor with id = 3: " + tempInstructor);

        tempInstructor.setEmail("davidbackham@Gmail.com");

        System.out.println("We change his email: " + tempInstructor);

        // set new instructor detail from instructor side
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        System.out.println("AYE: " +tempInstructor);

        // set new instructor from instructor detail side
        tempInstructorDetail.setInstructor(tempInstructor);


        System.out.println("We associate old instructor with new detail: " + tempInstructorDetail);

//        tempInstructorRepository.save(tempInstructor);

        tempInstructor.setEmail("kulibali");
        tempInstructorDetail.setInstructor(tempInstructor);

        instructorDetailRepository.save(tempInstructorDetail);



        System.out.println("Done!");

        context.close();
    }
}
