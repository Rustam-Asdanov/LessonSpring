package com.hibernate.a4_many_to_many.uni.example_2;

import com.hibernate.a4_many_to_many.uni.example_2.model.Student;
import com.hibernate.a4_many_to_many.uni.example_2.model.University;
import com.hibernate.a4_many_to_many.uni.example_2.repository.StudentRepository;
import com.hibernate.a4_many_to_many.uni.example_2.repository.UniversityRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TestSpring {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(TestSpring.class);
        UniversityRepository universityRepository =
                context.getBean("universityRepository", UniversityRepository.class);

        StudentRepository studentRepository =
                context.getBean("studentRepository", StudentRepository.class);

        Student firstStudent = new Student("David");
        Student secondStudent = new Student("Helen");

        List<Student> students = Arrays.asList(firstStudent, secondStudent);

        University university = new University("MIT",students);

        universityRepository.save(university);


        context.close();
    }
}
