package com.king.examplecrUD4;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class ConnectionDB {
    private final String URL = "jdbc:mysql://localhost:3310/exercise";
    private final String LOGIN = "root";
    private final String PASSWORD = "11111";
    private Connection connection;
    private Statement statement;

    {
        try {
            connection = DriverManager.getConnection(URL,LOGIN,PASSWORD);
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Statement getStatement(){return statement;}

}
