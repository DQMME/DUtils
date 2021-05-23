package de.dqmme.dutils.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class HitListener implements Listener {
    public String cause;

    @EventHandler
    private void onHit(EntityDamageByEntityEvent e) {
        cause = "[DEBUG] HitMessage is null. HitListener.java";
        Entity damager = e.getDamager();

        if(damager instanceof Player) {
            Player dammager = (Player) damager;

            cause = "Angriff [" + dammager.getName() + "]";
        } else {
            cause = "Angriff ["  + damager.getType() + "]";
        }
    }
}
