package com.yuriichuk.persistant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String url = "jdbc:mysql://localhost:3306/yuriichuk?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String user = "root";
    private static final String password = "1234";

    private static Connection connection;

    private ConnectionManager() {}

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                System.out.println("loh");
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
            }
        }
        return connection;
    }

}
