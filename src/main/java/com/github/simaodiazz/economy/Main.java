package com.github.simaodiazz.economy;

import com.github.simaodiazz.economy.model.user.manager.UserManager;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Getter
    private static Main instance;

    @Getter
    @Setter
    private HikariDataSource hikari;

    @Getter
    @Setter
    private UserManager userManager = new UserManager();

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        Loader loader = new Loader(instance);
        loader.setup();
    }

    @Override
    public void onDisable() {

    }
}