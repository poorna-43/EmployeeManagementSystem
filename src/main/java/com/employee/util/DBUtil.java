package com.employee.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    private static final String URL =
            "jdbc:mysql://localhost:3306/employee_db";

    private static final String USER = "root";
    private static final String PASSWORD = "ammr@2026";

    static {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

    }

    public static Connection getConnection() {

        try {

            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (Exception e) {

            throw new RuntimeException("Database Connection Failed", e);

        }

    }

}