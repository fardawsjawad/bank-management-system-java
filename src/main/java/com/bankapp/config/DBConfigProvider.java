package com.bankapp.config;

public interface DBConfigProvider {

    String getJdbcUrl();
    String getUsername();
    String getPassword();
    String getDriverClassName();
    int getMaxPoolSize();
    int getMinIdle();
    long getConnectionTimeout();
    long getMaxLifetime();

}
