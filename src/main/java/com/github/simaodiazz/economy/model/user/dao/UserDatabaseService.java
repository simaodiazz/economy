package com.github.simaodiazz.economy.model.user.dao;

import org.bukkit.entity.Player;
import com.github.simaodiazz.economy.model.user.User;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface UserDatabaseService {

    CompletableFuture<User> find(String name);
    CompletableFuture<User> find(UUID uuid);

    CompletableFuture<HashMap<String, User>> findAll();

    void create(User user);

    void update(User user);

}