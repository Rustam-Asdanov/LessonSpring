package com.aop.web_customer_tracker_aop.DAO;

import com.aop.web_customer_tracker_aop.model.People;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeopleDAO {
    private List<People> peopleList;

    public void addPeople(People people){
        if(peopleList==null){
            peopleList = new ArrayList<>();
        }

        people.setId(peopleList.size()+1);

        peopleList.add(people);
    }

    public List<People> getPeopleList() {
        return peopleList;
    }

    public void deleteElem(int id){
        peopleList.remove(id);
    }

    public void savePeople(People thePeople, int theId) {
        peopleList.set(theId, thePeople);
    }

    public People getPeople(int theId) {
        return peopleList.get(theId);
    }

//    @Autowired
//    private Configuration configuration;


//    public void addPeopleNew(People people){
//
//        this.configuration.configure("hibernate.cfg.xml")
//                        .addAnnotatedClass(People.class);
//
//       SessionFactory sessionFactory = configuration.buildSessionFactory();
//
//       Session session = sessionFactory.openSession();
//
//        Transaction tx = session.beginTransaction();
//
//       session.save(people);
//
//       tx.commit();
//
//       session.close();
//
//
//    }
}
