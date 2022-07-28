package ru.clevertec.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DBPropertiesManager {

    private static final Properties properties;

    private static final String PROPERTIES_FILE = "database.properties";
    private static final String URL = "database.url";
    private static final String USER = "database.user";
    private static final String PASSWORD = "database.password";
    private static final String DRIVER = "database.driver";
    private static final String POOL_SIZE = "database.pool.size";

    static {
        properties = new Properties();
        try {
            InputStream inputStream = DBPropertiesManager.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE);
            if (inputStream == null) {
                throw new RuntimeException("Properties file not found!");
            }
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static String getUrl() {
        return properties.getProperty(URL);
    }

    static String getUser() {
        return properties.getProperty(USER);
    }

    static String getPassword() {
        return properties.getProperty(PASSWORD);
    }

    static String getDriver() {
        return properties.getProperty(DRIVER);
    }

    static String getPoolSize() {
        return properties.getProperty(POOL_SIZE);
    }
}
