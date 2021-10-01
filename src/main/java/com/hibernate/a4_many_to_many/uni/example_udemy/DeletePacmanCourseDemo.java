package com.hibernate.a4_many_to_many.uni.example_udemy;


import com.hibernate.a4_many_to_many.uni.example_udemy.model.Course;
import com.hibernate.a4_many_to_many.uni.example_udemy.model.Student;
import com.hibernate.a4_many_to_many.uni.example_udemy.repository.CourseRepository;
import com.hibernate.a4_many_to_many.uni.example_udemy.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DeletePacmanCourseDemo {
    public static void main(String[] args){
        ConfigurableApplicationContext context =
                SpringApplication.run(DeletePacmanCourseDemo.class);

        CourseRepository courseRepository =
                context.getBean("courseRepository", CourseRepository.class);

        StudentRepository studentRepository =
                context.getBean("studentRepository", StudentRepository.class);


        // get the student mary from database
//        Course theCourse = courseRepository.findById(1).get();
//
//        System.out.println(theCourse);
//        courseRepository.delete(theCourse);

        System.out.println(studentRepository.findById(1).get());


        System.out.println("Success");
        context.close();
    }
}
