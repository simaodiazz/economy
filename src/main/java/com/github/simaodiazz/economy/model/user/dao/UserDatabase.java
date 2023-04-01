package com.github.simaodiazz.economy.model.user.dao;

import com.github.simaodiazz.economy.model.historic.parser.HistoricParser;
import com.github.simaodiazz.economy.model.user.adapter.UserAdapter;
import org.bukkit.entity.Player;
import com.github.simaodiazz.economy.Main;
import com.github.simaodiazz.economy.model.user.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class UserDatabase implements UserDatabaseService {

    private final UserAdapter userAdapter;
    private final HistoricParser historicParser;

    public UserDatabase() {
        userAdapter = new UserAdapter();
        historicParser = new HistoricParser();
    }

    @Override
    public CompletableFuture<User> find(String name) {
        CompletableFuture.supplyAsync( () -> {
            try (PreparedStatement preparedStatement = Main.getInstance().getHikari().getConnection().prepareStatement("SELECT name FROM economy_data WHERE name=?")) {
                preparedStatement.setString(1, name);
                ResultSet resultSet = preparedStatement.executeQuery();
                return userAdapter.adapt(resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        return null;
    }

    @Override
    public CompletableFuture<User> find(UUID uuid) {
        CompletableFuture.supplyAsync( () -> {
            try (PreparedStatement preparedStatement = Main.getInstance().getHikari().getConnection().prepareStatement("SELECT uuid FROM economy_data WHERE uuid=?")) {
                preparedStatement.setString(1, uuid.toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                return userAdapter.adapt(resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        return null;
    }

    @Override
    public CompletableFuture<HashMap<String, User>> findAll() {
        HashMap<String, User> cache = new HashMap<>();
        CompletableFuture.supplyAsync( () -> {
            try (PreparedStatement preparedStatement = Main.getInstance().getHikari().getConnection().prepareStatement("SELECT * FROM economy_data")) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    User user = userAdapter.adapt(resultSet);
                    cache.put(user.getName(), user);
                }
                return cache;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        return null;
    }

    @Override
    public void create(User user) {
        try (PreparedStatement preparedStatement = Main.getInstance().getHikari().getConnection().prepareStatement("INSERT INTO economy_data (uuid, name, balance, historic) VALUES (?, ?, ?, ?)")) {
            preparedStatement.setString(1, user.getUuid().toString());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setDouble(3, 0.0);
            preparedStatement.setString(4, "");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user) {
        try (PreparedStatement preparedStatement = Main.getInstance().getHikari().getConnection().prepareStatement("UPDATE economy_data SET name=?,balance=?,historic=? WHERE uuid=?")) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setDouble(2, user.getBalance());
            preparedStatement.setString(3, historicParser.parse(user.getHistoric()));
            preparedStatement.setString(4, user.getUuid().toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}