package edu.born.cool.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class DbConfig {
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/cooldb";
    private static final String DATABASE_USERNAME = "user";
    private static final String DATABASE_PASSWORD = "password";

    private DbConfig() {
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Objects.requireNonNull(connection);
    }
}
