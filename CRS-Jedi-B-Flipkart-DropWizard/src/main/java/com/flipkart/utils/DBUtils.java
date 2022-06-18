package com.flipkart.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
    public static Connection con = null;

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            System.out.println("i am here");
            Properties properties = new Properties();
            System.out.println("idhar bhi");

            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/crs";
            String username = "root";
            String password = "Blue_175989";
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("connection established");
        } catch (Exception e) {
            e.printStackTrace(); System.out.println(("djhgfjshg"));
        }
        return connection;
    }
}

