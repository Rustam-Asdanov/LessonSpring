package com.hibernate.a5_eager_vs_lazy.bi.example_udemy;


import com.hibernate.a5_eager_vs_lazy.bi.example_udemy.model.Course;
import com.hibernate.a5_eager_vs_lazy.bi.example_udemy.model.Instructor;
import com.hibernate.a5_eager_vs_lazy.bi.example_udemy.repository.CourseRepository;
import com.hibernate.a5_eager_vs_lazy.bi.example_udemy.repository.InstructorDetailRepository;
import com.hibernate.a5_eager_vs_lazy.bi.example_udemy.repository.InstructorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class EagerLazyDemo {

    public static void main(String[] args){
        ConfigurableApplicationContext context = SpringApplication.run(EagerLazyDemo.class);

        InstructorRepository instructorRepository =
                context.getBean("instructorRepository", InstructorRepository.class);

        InstructorDetailRepository instructorDetailRepository =
                context.getBean("instructorDetailRepository", InstructorDetailRepository.class);

        CourseRepository courseRepository =
                context.getBean("courseRepository", CourseRepository.class);



        // get the instructor from db

        // session start

        int theId=4;
        Instructor tempInstructor = instructorRepository.findById(theId).get();

//        Instructor

        System.out.println("Instructor: " + tempInstructor);

        // get courses for instructor
        System.out.println("\n Instructor Id: " + tempInstructor.getId()+"\n");

        try{
            System.out.println("\n Courses: " + tempInstructor.getCourses()+"\n");
        } catch (Exception ex){
            System.out.println("We can not download courses");
        }

        List<String> list_spec = new ArrayList<>();
        List<Course> listAll = (List<Course>) courseRepository.findAll();
        // session end

        for(Course c : listAll){
            if(c.getInstructor().getId() == theId){
                list_spec.add(c.getTitle());
            }
        }

        System.out.println(list_spec);

        System.out.println("Success");
    }
}
