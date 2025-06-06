package com.pluralsight.freedom404.db;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream("config.yml")) {
            if (input != null) {
                properties.load(input);
            } else {
                throw new RuntimeException("config.yml not found in classpath");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error loading config.yml", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
