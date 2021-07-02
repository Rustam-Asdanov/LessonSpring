package com.king.exampleCRUD.dao;

import com.king.exampleCRUD.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(1,"Tom"));
        people.add(new Person(2,"Bob"));
        people.add(new Person(3,"Mike"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){

        for(Person p : people){
            if(p.getId() == id){
                return p;
            }
            else {
                return null;
            }
        }
        return null;
//        return people.stream().filter(person->person.getId()==id).findAny().orElse(null);
    }
}
