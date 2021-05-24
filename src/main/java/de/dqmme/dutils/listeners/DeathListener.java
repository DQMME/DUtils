package de.dqmme.dutils.listeners;

import de.dqmme.dutils.utils.Messages;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {
    private final Messages messages = new Messages();

    @EventHandler(priority = EventPriority.LOWEST)
    private void onDeath(PlayerDeathEvent e) {
        e.setDeathMessage(messages.PLAYER_DIED.replace("%PLAYER%", e.getEntity().getName()));
    }
}
