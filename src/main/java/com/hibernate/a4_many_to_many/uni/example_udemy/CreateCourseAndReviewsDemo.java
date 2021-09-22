package com.hibernate.a4_many_to_many.uni.example_udemy;

import com.hibernate.a4_many_to_many.uni.example_udemy.model.Course;
import com.hibernate.a4_many_to_many.uni.example_udemy.model.Review;
import com.hibernate.a4_many_to_many.uni.example_udemy.repository.CourseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CreateCourseAndReviewsDemo {
    public static void main(String[] args){
        ConfigurableApplicationContext context =
                SpringApplication.run(CreateCourseAndReviewsDemo.class);

        CourseRepository courseRepository =
                context.getBean("courseRepository", CourseRepository.class);

        // create a course
        Course tempCourse = new Course("Pacman - How To Score One Million Points");

        // add some reviews
        tempCourse.addReview(new Review("Great course ... love it!"));
        tempCourse.addReview(new Review("Cool course, job well done."));
        tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));

        // save the course ... and the leverage the cascade all :-)
        courseRepository.save(tempCourse);


        System.out.println("Success");
        context.close();
    }
}
