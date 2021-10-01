package com.hibernate.a5_eager_vs_lazy.bi.example_udemy;


import com.hibernate.a5_eager_vs_lazy.bi.example_udemy.model.Instructor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class VolosatiyEagerLazyDemo {

    @Autowired
    private SessionFactory sessionFactory;

    public static void main(String[] args){
        SpringApplication.run(VolosatiyEagerLazyDemo.class);

        VolosatiyEagerLazyDemo volosatiyEagerLazyDemo = new VolosatiyEagerLazyDemo();
        volosatiyEagerLazyDemo.ujeQolovaBolit();



    }

    public void ujeQolovaBolit(){
        // create session
        Session session = sessionFactory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // get the instructor from db
            int theId = 1;
            Instructor tempInstructor = (Instructor) session.get(Instructor.class, theId);

            System.out.println("Instructor: " + tempInstructor);

            // get courses for the instructor
            System.out.println("Courses: " + tempInstructor.getCourses());

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {

            // add clean up code
            session.close();

            sessionFactory.close();
        }


        System.out.println("Success");
    }
}
