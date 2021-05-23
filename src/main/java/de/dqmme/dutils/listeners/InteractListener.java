package de.dqmme.dutils.listeners;

import de.dqmme.dutils.utils.GameruleUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractListener implements Listener {
    private final GameruleUtils gameruleUtils = new GameruleUtils();

    @EventHandler
    private void onInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        if(gameruleUtils.getSoup()) {
            if(!gameruleUtils.getUUHC()) {
                if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                    if(e.getItem().getType().equals(Material.MUSHROOM_STEW)) {
                        if(player.getHealth() != player.getMaxHealth()) {
                            if(player.getHealth()+4 > player.getMaxHealth()) {
                                player.setHealth(player.getMaxHealth());
                            } else {
                                player.setHealth(player.getHealth() + 4);
                            }
                        }
                    }
                }
            }
        }
    }
}
