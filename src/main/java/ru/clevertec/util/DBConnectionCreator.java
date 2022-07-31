package ru.clevertec.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DBConnectionCreator {

    private static final String DATABASE_URL = DBPropertiesManager.getUrl();
    private static final String DATABASE_USER = DBPropertiesManager.getUser();
    private static final String DATABASE_PASSWORD = DBPropertiesManager.getPassword();

    static Connection createConnection(){
        Connection connection;
        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Connection not created!", e);
        }
        return connection;
    }
}
