package com.example.pizza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static String DBurl = "jdbc:mysql://localhost:3306/rapizz";
    public static String user = "root";
    public static String password = "root";

    public static Connection conn;
    public static Connection GetConn() throws SQLException {
        if (DBConnection.conn == null){
            DBConnection.conn = DriverManager.getConnection(DBurl,user,password);
        }
        return DBConnection.conn;
    }
}
