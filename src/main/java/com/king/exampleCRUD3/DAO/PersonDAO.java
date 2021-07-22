package com.king.exampleCRUD3.DAO;

import com.king.exampleCRUD3.ConnectionDB;
import com.king.exampleCRUD3.model.Person;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PersonDAO {

    @Autowired
    private ConnectionDB connectionDB;

    public void insert(Person person){
        String query = String.format("insert into people(name) values('%s');",person.getName());
        try {
            connectionDB.getStatement().executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Person> getData(){
        List<Person> listPerson = new ArrayList<>();
        try {
            ResultSet resultSet = connectionDB.getStatement().executeQuery("select * from people;");
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                listPerson.add(new Person(id,name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listPerson;
    }

    public Person getPerson(int mainId){
        try {
            ResultSet resultSet =
                    connectionDB.getStatement().executeQuery("select * from person where id="+mainId+";");

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                return new Person(id,name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    private void update(Person person){
        String query = String.format("update person " +
                "set name='%s', where id=%d;",person.getName(), person.getId());

        try {
            connectionDB.getStatement().executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
