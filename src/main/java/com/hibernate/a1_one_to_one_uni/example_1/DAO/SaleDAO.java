package com.hibernate.a1_one_to_one_uni.example_1.DAO;

import com.hibernate.a1_one_to_one_uni.example_1.models.Human;
import com.hibernate.a1_one_to_one_uni.example_1.models.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaleDAO {

    private SessionFactory factory;
    private Session session;

    {
        /*
        Properties properties = new Properties();

        properties.setProperty("dialect","org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.connection.driver_class","com.mysql.cj.jdbc.Driver");
        properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3310/hb-01-one-to-one-uni");
        properties.setProperty("hibernate.connection.username","root");
        properties.setProperty("hibernate.connection.password","11111");
        properties.setProperty("show_sql","true");


        factory = new Configuration().addProperties(properties)
                                    .addAnnotatedClass(Human.class)
                                    .addAnnotatedClass(Orders.class)
                                    .buildSessionFactory();

        session = factory.openSession();

*/

        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Human.class)
                .addAnnotatedClass(Orders.class)
                .buildSessionFactory();

        session = factory.getCurrentSession();

    }

    public void insertData(Human human, Orders orders){
        System.out.println(human);
        human.setHuman_orders(orders);

        session.beginTransaction();

        System.out.println("Saving " + human);

        Human theHuman = new Human("Mamedik","Baki");
        Orders theOrders = new Orders("Laptop","1000$");
        theHuman.setHuman_orders(theOrders);

        session.save(theHuman);

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
