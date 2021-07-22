package com.king.examplecrUD4.DAO;

import com.king.examplecrUD4.ConnectionDB;
import com.king.examplecrUD4.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    @Autowired
    private ConnectionDB connectionDB;

    public List<Person> getPeopleData(){
        List<Person> list = new ArrayList<>();
        try {
            ResultSet resultSet = connectionDB.getStatement().executeQuery("select * from person;");
            while(resultSet.next()){
                list.add(new Person(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
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
                "insert into person values(null,'%s','%s');",person.getName(), person.getCoutnry());
        try {
            connectionDB.getStatement().executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
