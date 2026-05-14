package com.roberto.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory  implements AutoCloseable{

    private final HikariDataSource dataSource;

    public ConnectionFactory(DatabaseConfig databaseConfig){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(databaseConfig.url());
        config.setUsername(databaseConfig.user());
        config.setPassword(databaseConfig.password());
        config.setMaximumPoolSize(databaseConfig.poolSize());

        this.dataSource = new HikariDataSource(config);
    }

    public Connection getConnection()throws SQLException {
        return dataSource.getConnection();
    }

    @Override
    public void close() {
        dataSource.close();
    }
}
