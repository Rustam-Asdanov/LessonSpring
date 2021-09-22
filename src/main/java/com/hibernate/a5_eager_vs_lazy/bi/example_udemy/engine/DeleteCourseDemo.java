package com.hibernate.a5_eager_vs_lazy.bi.example_udemy.engine;

import com.hibernate.a5_eager_vs_lazy.bi.example_udemy.model.Course;
import com.hibernate.a5_eager_vs_lazy.bi.example_udemy.repository.CourseRepository;
import com.hibernate.a5_eager_vs_lazy.bi.example_udemy.repository.InstructorDetailRepository;
import com.hibernate.a5_eager_vs_lazy.bi.example_udemy.repository.InstructorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DeleteCourseDemo {
    public static void main(String[] args){
        ConfigurableApplicationContext context =
                SpringApplication.run(DeleteCourseDemo.class);

        InstructorRepository instructorRepository =
                context.getBean("instructorRepository", InstructorRepository.class);

        InstructorDetailRepository instructorDetailRepository =
                context.getBean("instructorDetailRepository", InstructorDetailRepository.class);

        CourseRepository courseRepository =
                context.getBean("courseRepository", CourseRepository.class);

       // get a course
        int theId=1;
        Course tempCourse = courseRepository.findById(theId).get();

        // delete course
        System.out.println("Deleting course: " + tempCourse);


        courseRepository.delete(tempCourse);

        System.out.println("Success");
        context.close();
    }
}
