package com.hibernate.a4_many_to_many.uni.example_udemy;

import com.hibernate.a4_many_to_many.uni.example_udemy.model.Course;
import com.hibernate.a4_many_to_many.uni.example_udemy.model.Review;
import com.hibernate.a4_many_to_many.uni.example_udemy.repository.CourseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class GetInstructorCoursesDemo {
    public static void main(String[] args){
        ConfigurableApplicationContext context =
                SpringApplication.run(GetInstructorCoursesDemo.class);


        CourseRepository courseRepository =
                context.getBean("courseRepository", CourseRepository.class);

        // get the instructor from db

        List<Course> courses = courseRepository.findAll();
        List<Review> reviewList = new ArrayList<>();

        for(Course c : courses){
            if(c.getReviews() != null){
                reviewList.add(c.getReviews().get(1));
            }
        }

//        System.out.println(courses.get(15).getReviews());


        System.out.println("Success");
        context.close();
    }
}
