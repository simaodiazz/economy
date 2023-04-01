package com.github.simaodiazz.economy.listener;

import com.github.simaodiazz.economy.Main;
import com.github.simaodiazz.economy.model.historic.Historic;
import com.github.simaodiazz.economy.model.user.User;
import lombok.AllArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

@AllArgsConstructor
public class PlayerJoinListener implements Listener {

    private Main main;

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        if (main.getUserManager().find(player.getUniqueId()) == null) {

            User user = new User();
            user.setUuid(player.getUniqueId());
            user.setName(player.getName());
            user.setBalance(0.0);
            user.setHistoric(new Historic());

            main.getUserManager().create(user);

        } else {

            main.getUserManager().load(player.getUniqueId(), player.getName());

        }
    }
}