package de.dqmme.dutils.listeners;

import de.dqmme.dutils.DUtils;
import de.dqmme.dutils.utils.ChallengeUtils;
import de.dqmme.dutils.utils.GameruleUtils;
import de.dqmme.dutils.utils.Messages;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    private final Messages messages = new Messages();
    private final GameruleUtils gameruleUtils = new GameruleUtils();
    private final ChallengeUtils challengeUtils = new ChallengeUtils();

    @EventHandler
    private void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        player.setMaxHealth(gameruleUtils.getMaxHealth());
        player.setHealth(player.getHealth());

        e.setJoinMessage(messages.PLAYER_JOINED.replace("%PLAYER%", player.getName()));

        if(challengeUtils.getRandomItem()) {
            DUtils.getPlugin(DUtils.class).bossBar.addPlayer(player);

            World worldRandomItem = Bukkit.getWorld("world_random_item");

            if(worldRandomItem != null) {
                Bukkit.getScheduler().runTaskLater(DUtils.getPlugin(DUtils.class), () -> {
                    player.teleport(worldRandomItem.getSpawnLocation());
                }, 3);
            }
        }
    }
}
