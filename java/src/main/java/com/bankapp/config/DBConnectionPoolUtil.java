package com.bankapp.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionPoolUtil {

    private static HikariDataSource dataSource;
    private static PropertiesDBConfigProvider props;

    static {

            props = new PropertiesDBConfigProvider();

            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(props.getJdbcUrl());
            config.setUsername(props.getUsername());
            config.setPassword(props.getPassword());
            config.setDriverClassName(props.getDriverClassName());

            config.setMaximumPoolSize(props.getMaxPoolSize());
            config.setConnectionTimeout(props.getConnectionTimeout());
            config.setMinimumIdle(props.getMinIdle());
            config.setMaxLifetime(props.getMaxLifetime());

            dataSource = new HikariDataSource(config);

    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void shutdownPool() {
        if (dataSource != null && !dataSource.isClosed()) {
            dataSource.close();
        }
    }
}
