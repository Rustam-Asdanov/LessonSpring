package com.king.exampleCRUD2.dao;

import com.king.exampleCRUD2.ConnectionDB;
import com.king.exampleCRUD2.models.Humans;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

public class HumansDAO {
    @Autowired
    private ConnectionDB connectionDB;

    public void insert(Humans humans){
        String query = String.format(
                "insert into humans(name,surname,email) values('%s','%s','%s');",
                humans.getName(),humans.getSurname(),humans.getEmail()
        );

        try {
            connectionDB.getStatement().executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
