package com.github.simaodiazz.economy;

import com.github.simaodiazz.economy.database.SQLProvider;
import com.github.simaodiazz.economy.model.user.manager.UserManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Loader {

    private Main main;

    public void setup() {
        // Connect to database
        SQLProvider sqlProvider = new SQLProvider(main);
        sqlProvider.setup();

        // Register listeners

        // Register commands
    }
}