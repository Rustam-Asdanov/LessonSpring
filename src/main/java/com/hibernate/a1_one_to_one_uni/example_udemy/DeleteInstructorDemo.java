package com.hibernate.a1_one_to_one_uni.example_udemy;


import com.hibernate.a1_one_to_one_uni.example_udemy.model.Instructor;
import com.hibernate.a1_one_to_one_uni.example_udemy.repository.InstructorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DeleteInstructorDemo {
    public static void main(String[] args){
        ConfigurableApplicationContext context = SpringApplication.run(DeleteInstructorDemo.class);

        InstructorRepository instructorRepository =
                context.getBean("instructorRepository", InstructorRepository.class);

        // get instructor by primary key /id

        int theId = 1;

        Instructor tempInstructor = instructorRepository.findById(theId).get();
        System.out.println(tempInstructor);

        // delete the instructor

        if(tempInstructor != null){
            System.out.println("Deleting: " + tempInstructor);

            instructorRepository.delete(tempInstructor);
        }

        System.out.println("Done!");

        context.close();
    }
}
