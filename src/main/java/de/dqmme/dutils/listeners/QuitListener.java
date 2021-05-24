package de.dqmme.dutils.listeners;

import de.dqmme.dutils.DUtils;
import de.dqmme.dutils.utils.Messages;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {
    private final Messages messages = new Messages();

    @EventHandler
    private void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();

        e.setQuitMessage(messages.PLAYER_LEFT.replace("%PLAYER%", player.getName()));

        if(DUtils.getPlugin(DUtils.class).bossBar.getPlayers().contains(player)) {
            DUtils.getPlugin(DUtils.class).bossBar.removePlayer(player);
        }
    }
}
