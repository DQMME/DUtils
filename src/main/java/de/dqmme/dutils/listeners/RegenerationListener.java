package de.dqmme.dutils.listeners;

import de.dqmme.dutils.utils.GameruleUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;

public class RegenerationListener implements Listener {
    private final GameruleUtils gameruleUtils = new GameruleUtils();

    @EventHandler
    private void onRegen(EntityRegainHealthEvent e) {
        if(e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();

            if(gameruleUtils.getUUHC()) {
                e.setCancelled(true);
            }
        }
    }
}
