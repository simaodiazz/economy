package com.github.simaodiazz.economy.model.user.repository;

import lombok.AllArgsConstructor;
import com.github.simaodiazz.economy.Main;
import com.github.simaodiazz.economy.database.repository.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@AllArgsConstructor
public class UserRepository implements Repository {

    private Main main;

    @Override
    public void create() {
        try (PreparedStatement preparedStatement = main.getHikari().getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS economy_data (uuid VARCHAR(36) NOT NULL PRIMARY KEY, name VARCHAR(16) NOT NULL, balance DOUBLE NOT NULL DEFAULT 0, transactions LONGTEXT NOT NULL)")) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete() {
        try (PreparedStatement preparedStatement = main.getHikari().getConnection().prepareStatement("DELETE FROM economy_data")) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}