package com.hibernate.a4_many_to_many.uni.example_udemy;

import com.hibernate.a4_many_to_many.uni.example_udemy.conn.ConnectionData;
import com.hibernate.a4_many_to_many.uni.example_udemy.model.Student;
import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AddManyCoursesAndStudents {

    public static void main(String[] args){

        SpringApplication.run(AddManyCoursesAndStudents.class);

        ConnectionData connectionData = new ConnectionData();

        Session session = connectionData.getSession();

        session.beginTransaction();

//        Student tempStudent = new Student("Marry Helliot");
//
//        session.save(tempStudent);

        Student tempStudentNew = session.get(Student.class,5);

        System.out.println("New Student: " + tempStudentNew);

        session.getTransaction().commit();

        System.out.println("Done!");

        connectionData.sessionClose();
        connectionData.factoryClose();
    }
}
