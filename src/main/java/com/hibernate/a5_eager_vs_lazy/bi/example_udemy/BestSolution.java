package com.hibernate.a5_eager_vs_lazy.bi.example_udemy;


import com.hibernate.a5_eager_vs_lazy.bi.example_udemy.model.Course;
import com.hibernate.a5_eager_vs_lazy.bi.example_udemy.model.InstructorDetail;
import com.hibernate.a5_eager_vs_lazy.bi.example_udemy.model.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class BestSolution {

    public static void main(String[] args){
        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

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

            factory.close();
        }


        System.out.println("Success");
    }
}
