package com.github.simaodiazz.economy.database;

import com.github.simaodiazz.economy.model.user.repository.UserRepository;
import com.zaxxer.hikari.HikariDataSource;
import lombok.AllArgsConstructor;
import com.github.simaodiazz.economy.Main;

@AllArgsConstructor
public class SQLProvider {

    private Main main;

    public void setup() {

        HikariDataSource hikari = new HikariDataSource();

        hikari.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");

        hikari.addDataSourceProperty("serverName", main.getConfig().getString("mysql.serverName"));
        hikari.addDataSourceProperty("port", main.getConfig().getString("mysql.port"));
        hikari.addDataSourceProperty("databaseName", main.getConfig().getString("mysql.databaseName"));
        hikari.addDataSourceProperty("user", main.getConfig().getString("mysql.user"));
        hikari.addDataSourceProperty("password", main.getConfig().getString("mysql.password"));

        hikari.setAutoCommit(true);
        hikari.addDataSourceProperty("characterEncoding", "utf8");
        hikari.addDataSourceProperty("autoReconnect", "true");
        hikari.addDataSourceProperty("cachePrepStmts", "true");
        hikari.addDataSourceProperty("useServerPrepStmts", "true");
        hikari.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        hikari.addDataSourceProperty("rewriteBatchedStatements", "true");
        hikari.addDataSourceProperty("maximumPoolSize", "50");
        hikari.addDataSourceProperty("minimumIdle", "20");
        hikari.addDataSourceProperty("idleTimeout", "30000");
        hikari.addDataSourceProperty("connectionTimeout", "10000");
        hikari.addDataSourceProperty("maxLifetime", "1800000");
        hikari.addDataSourceProperty("cachePrepStmts", "true");
        hikari.addDataSourceProperty("prepStmtCacheSize", "100");
        hikari.addDataSourceProperty("prepStmtCacheSqlLimit", "1024");

        UserRepository userRepository = new UserRepository(main);
        userRepository.create();

        main.setHikari(hikari);
    }
}