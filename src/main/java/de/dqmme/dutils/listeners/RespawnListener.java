package de.dqmme.dutils.listeners;

import de.dqmme.dutils.utils.ChallengeUtils;
import de.dqmme.dutils.utils.GameruleUtils;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RespawnListener implements Listener {
    private final ChallengeUtils challengeUtils = new ChallengeUtils();

    @EventHandler
    private void onRespawn(PlayerRespawnEvent e) {
        Player player = e.getPlayer();

        if(challengeUtils.getRandomItem()) {
            World worldRandomItem = Bukkit.getWorld("world_random_item");
            if(worldRandomItem != null) {
                e.setRespawnLocation(worldRandomItem.getSpawnLocation());
            }
        }
    }
}
