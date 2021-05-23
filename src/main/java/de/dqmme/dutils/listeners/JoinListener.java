package de.dqmme.dutils.listeners;

import de.dqmme.dutils.utils.GameruleUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    private final GameruleUtils gameruleUtils = new GameruleUtils();

    @EventHandler
    private void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        player.setMaxHealth(gameruleUtils.getMaxHealth());
        player.setHealth(player.getHealth());
    }
}
