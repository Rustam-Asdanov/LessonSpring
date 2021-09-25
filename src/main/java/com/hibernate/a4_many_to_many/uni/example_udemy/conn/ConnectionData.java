package com.hibernate.a4_many_to_many.uni.example_udemy.conn;

import com.hibernate.a4_many_to_many.uni.example_udemy.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionData {
    private SessionFactory sessionFactory;
    private Session session;

    {
        if(sessionFactory == null){
            sessionFactory = new Configuration()
                            .configure("hibernate.cfg.xml")
                            .addAnnotatedClass(Course.class)
                            .addAnnotatedClass(Instructor.class)
                            .addAnnotatedClass(InstructorDetail.class)
                            .addAnnotatedClass(Review.class)
                            .addAnnotatedClass(Student.class)
                            .buildSessionFactory();
        }
    }

    public Session getSession(){
        session = sessionFactory.getCurrentSession();
        return session;
    }

    public void sessionClose(){
        session.close();
    }

    public void factoryClose(){
        sessionFactory.close();
    }
}
