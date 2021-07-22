package com.king.examplecrUD4.DAO;

import com.king.examplecrUD4.ConnectionDB;
import com.king.examplecrUD4.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    @Autowired
    private ConnectionDB connectionDB;

    public List<Person> getPeopleData(){
        List<Person> list = new ArrayList<>();
        try {
            ResultSet resultSet = connectionDB.getStatement().executeQuery("select * from person;");
            while(resultSet.next()){
                list.add(new Person(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("country")
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    public Person getPerson(int index){
        try {
            ResultSet resultSet = connectionDB.getStatement().executeQuery("select * from person where id="+index);
            while(resultSet.next()){
                return new Person(
                        resultSet.getString(2),
                        resultSet.getString(3)
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void insertPerson(Person person){
        String query = String.format(
                "insert into person values(null,'%s','%s');",person.getName(), person.getCountry());
        try {
            connectionDB.getStatement().executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(Person person){
        String query = String.format("update person set name='%s',country='%s' where id=%d;",
                person.getName(), person.getCountry(), person.getId());
        try {
            connectionDB.getStatement().executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int id){
        String query = String.format("delete from person where id="+id);
        try {
            connectionDB.getStatement().executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
