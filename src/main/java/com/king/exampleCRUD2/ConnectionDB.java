package com.king.exampleCRUD2;

import org.springframework.stereotype.Component;

import java.sql.*;


@Component
public class ConnectionDB {
    private static final String URL = "jdbc:mysql://localhost:3310/exercise";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "11111";
    private static Connection conn;
    private static Statement statement;

    static {
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
