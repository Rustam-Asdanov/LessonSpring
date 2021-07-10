package com.hibernate.one_to_one_uni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {
    private final String URL = "jdbc:mysql://localhost:3310/hb-01-one-to-one-uni";
    private final String LOGIN = "root";
    private final String PASSWORD = "11111";
    private Connection conn;
    private Statement statement;

    {
        try {
            conn = DriverManager.getConnection(URL,LOGIN,PASSWORD);
            statement = conn.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Statement getStatement(){
        return statement;
    }
}
