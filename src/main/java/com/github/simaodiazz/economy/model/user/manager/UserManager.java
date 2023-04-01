package com.github.simaodiazz.economy.model.user.manager;

import com.github.simaodiazz.economy.model.user.User;
import com.github.simaodiazz.economy.model.user.dao.UserDatabase;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class UserManager {

    private final HashMap<String, User> users;

    private final UserDatabase userDatabase;

    public UserManager() {
        this.users = new HashMap<>();
        this.userDatabase = new UserDatabase();
    }

    public User get(String name) {
        return users.get(name);
    }

    public User find(String name) {
        try {
            return userDatabase.find(name).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public User find(UUID uuid) {
        try {
            return userDatabase.find(uuid).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public HashMap<String, User> getAll() {
        return users;
    }

    public HashMap<String, User> findAll() {
        try {
            return userDatabase.findAll().get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public void put(User user) {
        users.put(user.getName(), user);
    }

    public void create(User user) {
        userDatabase.create(user);
    }

    public void update(User user) {
        userDatabase.update(user);
    }
}