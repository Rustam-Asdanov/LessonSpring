package com.hibernate.a1_one_to_one_uni.example_1;

import com.hibernate.a1_one_to_one_uni.example_1.models.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication {
    public static void main(String[] args){
        SpringApplication.run(WebApplication.class);
        System.out.println("Project ONE TO ONE UNI is started");

        Configuration configuration = new Configuration().configure()

                                            .addAnnotatedClass(Orders.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();


        Orders theOrders = new Orders("Laptop","1000$");

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        session.save(theOrders);

        tx.commit();

        session.close();
    }
}
