package com.hibernate.a4_many_to_many.uni.example_udemy;


import com.hibernate.a4_many_to_many.uni.example_udemy.model.Course;
import com.hibernate.a4_many_to_many.uni.example_udemy.model.Student;
import com.hibernate.a4_many_to_many.uni.example_udemy.repository.CourseRepository;
import com.hibernate.a4_many_to_many.uni.example_udemy.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AddCoursesForMaryDemo {
    public static void main(String[] args){
        ConfigurableApplicationContext context =
                SpringApplication.run(AddCoursesForMaryDemo.class);

        CourseRepository courseRepository =
                context.getBean("courseRepository", CourseRepository.class);

        StudentRepository studentRepository =
                context.getBean("studentRepository", StudentRepository.class);


        // create the students
        Student tempStudent1 = new Student("Mary Beut");

        studentRepository.save(tempStudent1);

        // get the student mary from database
        Student tempStudent = studentRepository.findById(5).get();

        System.out.println("\nLoaded student: " + tempStudent);
//        System.out.println("Courses: " + tempStudent.getCourseList());

        // create more courses
        Course tempCourseOne = new Course("Rubik Courses");
        Course tempCourseTwo = new Course("Katana Courses");

        // add student to courses
        tempCourseOne.addStudent(tempStudent);
        tempCourseTwo.addStudent(tempStudent);

        // save the courses
        System.out.println("\nSaving the courses...");

        courseRepository.save(tempCourseOne);
        courseRepository.save(tempCourseTwo);

        System.out.println("Success");
        context.close();
    }
}
