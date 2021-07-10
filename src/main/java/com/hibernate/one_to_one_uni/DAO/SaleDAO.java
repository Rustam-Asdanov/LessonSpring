package com.hibernate.one_to_one_uni.DAO;

import com.hibernate.one_to_one_uni.models.Human;
import com.hibernate.one_to_one_uni.models.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Properties;

@Component
public class SaleDAO {

    private SessionFactory factory;
    private Session session;

    {
        Properties properties = new Properties();
        properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3310/hb-01-one-to-one-uni");

        properties.setProperty("dialect","org.hibernate.dialect.MySQL");

        properties.setProperty("hibernate.connection.username","root");
        properties.setProperty("hibernate.connection.password","11111");


        factory = new Configuration().addProperties(properties)
                                    .addAnnotatedClass(Human.class)
                                    .addAnnotatedClass(Orders.class)
                                    .buildSessionFactory();

        session = factory.getCurrentSession();
    }

    public void insertData(Human human, Orders orders){
        human.setHuman_orders(orders);

        session.beginTransaction();

        System.out.println("Saving " + human);

        session.save(human);

        session.getTransaction().commit();

        System.out.println("Done!");

        factory.close();
    }

    public List getHumanList(){
        return session.createQuery("from human").getResultList();
    }

    public List getOrdersList(){
        return session.createQuery("from orders").getResultList();
    }

}
