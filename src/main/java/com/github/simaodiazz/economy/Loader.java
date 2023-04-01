package com.github.simaodiazz.economy;

import com.github.simaodiazz.economy.database.SQLProvider;
import com.github.simaodiazz.economy.listener.PlayerJoinListener;

import lombok.AllArgsConstructor;
import org.bukkit.Bukkit;

@AllArgsConstructor
public class Loader {

    private Main main;

    public void setup() {
        // Connect to database
        SQLProvider sqlProvider = new SQLProvider(main);
        sqlProvider.setup();

        // Register listeners
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(main), main);

        // Register commands
    }
}