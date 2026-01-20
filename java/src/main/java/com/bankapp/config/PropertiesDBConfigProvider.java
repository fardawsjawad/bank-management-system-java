package com.bankapp.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesDBConfigProvider implements DBConfigProvider {

    private final Properties props =  new Properties();

    public PropertiesDBConfigProvider() {
        try (InputStream input =
                getClass().getClassLoader().getResourceAsStream("db.properties")) {
            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load DB properties", e);
        }
    }

    @Override
    public String getJdbcUrl() {
        return props.getProperty("db.url");
    }

    @Override
    public String getUsername() {
        return props.getProperty("db.username");
    }

    @Override
    public String getPassword() {
        return props.getProperty("db.password");
    }

    @Override
    public String getDriverClassName() {
        return props.getProperty("db.driver");
    }

    @Override
    public int getMaxPoolSize() {
        return Integer.parseInt(props.getProperty("db.pool.size"));
    }

    @Override
    public int getMinIdle() {
        return Integer.parseInt(props.getProperty("db.pool.minIdle"));
    }

    @Override
    public long getConnectionTimeout() {
        return Long.parseLong(props.getProperty("db.pool.timeout"));
    }

    @Override
    public long getMaxLifetime() {
        return Long.parseLong(props.getProperty("db.pool.maxLifetime"));
    }
}
