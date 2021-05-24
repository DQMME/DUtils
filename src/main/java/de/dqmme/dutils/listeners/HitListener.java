package de.dqmme.dutils.listeners;

import de.dqmme.dutils.DUtils;
import de.dqmme.dutils.utils.Messages;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class HitListener implements Listener {
    private final Messages messages = new Messages();

    @EventHandler(priority = EventPriority.HIGHEST)
    private void onHit(EntityDamageByEntityEvent e) {
        if(e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();
            double hearts = e.getDamage()/2;

            if(e.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK)) {
                Bukkit.broadcastMessage(messages.DAMAGE_TAKEN.replace("%PLAYER%", player.getName()).replace("%CAUSE%", "Angriff [" + e.getDamager().getName() + "]").replace("%DAMAGE%", hearts + ""));
            }
        }
    }
}
