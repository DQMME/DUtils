package de.dqmme.dutils.listeners;

import de.dqmme.dutils.utils.GameruleUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageListener implements Listener {
    private final GameruleUtils gameruleUtils = new GameruleUtils();

    @EventHandler
    private void onDamage(EntityDamageEvent e) {
        if(e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();

            if(gameruleUtils.getSplitHealth()) {
                if(e.getCause() != EntityDamageEvent.DamageCause.CUSTOM) {
                    for(Player all : Bukkit.getOnlinePlayers()) {
                        //all.setHealth(all.getHealth()-e.getDamage());
                        all.damage(e.getDamage());
                        e.setCancelled(true);
                    }
                }
            }

            if(gameruleUtils.getDamageMessages()) {
                Bukkit.broadcastMessage(e.getCause() + "");
            }
        }
    }
}
