package de.dqmme.dutils.listeners;

import de.dqmme.dutils.DUtils;
import de.dqmme.dutils.utils.ChallengeUtils;
import de.dqmme.dutils.utils.GameruleUtils;
import de.dqmme.dutils.utils.Messages;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.util.List;

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

        if(challengeUtils.getInvSync()) {
            if(Bukkit.getOnlinePlayers().size() > 1) {
                List <Player> players = (List<Player>) Bukkit.getOnlinePlayers();
                players.remove(player);
                for(Player all : players) {
                    syncInventory(all);
                }
            }
        }

        if(gameruleUtils.getHealthInTab()) {
            Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective objective = board.getObjective("showhealth");
            if (objective == null) {
                String dName = ChatColor.RED + "\u2665";
                objective = board.registerNewObjective("showhealth", "health", dName, gameruleUtils.getHealthInTabType());
                objective.setDisplaySlot(DisplaySlot.PLAYER_LIST);
            }
            player.setScoreboard(board);
        } else {
            Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective objective = board.getObjective("showhealth");
            if (objective != null) {
                objective.unregister();
            }
            player.setScoreboard(board);
        }

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

    public void syncInventory(Player player) {
        ItemStack slot0 = player.getInventory().getItem(0);
        ItemStack slot1 = player.getInventory().getItem(1);
        ItemStack slot2 = player.getInventory().getItem(2);
        ItemStack slot3 = player.getInventory().getItem(3);
        ItemStack slot4 = player.getInventory().getItem(4);
        ItemStack slot5 = player.getInventory().getItem(5);
        ItemStack slot6 = player.getInventory().getItem(6);
        ItemStack slot7 = player.getInventory().getItem(7);
        ItemStack slot8 = player.getInventory().getItem(8);
        ItemStack slot9 = player.getInventory().getItem(9);
        ItemStack slot10 = player.getInventory().getItem(10);
        ItemStack slot11 = player.getInventory().getItem(11);
        ItemStack slot12 = player.getInventory().getItem(12);
        ItemStack slot13 = player.getInventory().getItem(13);
        ItemStack slot14 = player.getInventory().getItem(14);
        ItemStack slot15 = player.getInventory().getItem(15);
        ItemStack slot16 = player.getInventory().getItem(16);
        ItemStack slot17 = player.getInventory().getItem(17);
        ItemStack slot18 = player.getInventory().getItem(18);
        ItemStack slot19 = player.getInventory().getItem(19);
        ItemStack slot20 = player.getInventory().getItem(20);
        ItemStack slot21 = player.getInventory().getItem(21);
        ItemStack slot22 = player.getInventory().getItem(22);
        ItemStack slot23 = player.getInventory().getItem(23);
        ItemStack slot24 = player.getInventory().getItem(24);
        ItemStack slot25 = player.getInventory().getItem(25);
        ItemStack slot26 = player.getInventory().getItem(26);
        ItemStack slot27 = player.getInventory().getItem(27);
        ItemStack slot28 = player.getInventory().getItem(28);
        ItemStack slot29 = player.getInventory().getItem(29);
        ItemStack slot30 = player.getInventory().getItem(30);
        ItemStack slot31 = player.getInventory().getItem(31);
        ItemStack slot32 = player.getInventory().getItem(32);
        ItemStack slot33 = player.getInventory().getItem(33);
        ItemStack slot34 = player.getInventory().getItem(34);
        ItemStack slot35 = player.getInventory().getItem(35);

        ItemStack offHand = player.getInventory().getItemInOffHand();

        ItemStack helmet = player.getInventory().getHelmet();
        ItemStack chestplate = player.getInventory().getHelmet();
        ItemStack leggings = player.getInventory().getLeggings();
        ItemStack boots = player.getInventory().getBoots();

        for(Player all : Bukkit.getOnlinePlayers()) {
            all.getInventory().setItem(0, slot0);
            all.getInventory().setItem(1, slot1);
            all.getInventory().setItem(2, slot2);
            all.getInventory().setItem(3, slot3);
            all.getInventory().setItem(4, slot4);
            all.getInventory().setItem(5, slot5);
            all.getInventory().setItem(6, slot6);
            all.getInventory().setItem(7, slot7);
            all.getInventory().setItem(8, slot8);
            all.getInventory().setItem(9, slot9);
            all.getInventory().setItem(10, slot10);
            all.getInventory().setItem(11, slot11);
            all.getInventory().setItem(12, slot12);
            all.getInventory().setItem(13, slot13);
            all.getInventory().setItem(14, slot14);
            all.getInventory().setItem(15, slot15);
            all.getInventory().setItem(16, slot16);
            all.getInventory().setItem(17, slot17);
            all.getInventory().setItem(18, slot18);
            all.getInventory().setItem(19, slot19);
            all.getInventory().setItem(20, slot20);
            all.getInventory().setItem(21, slot21);
            all.getInventory().setItem(22, slot22);
            all.getInventory().setItem(23, slot23);
            all.getInventory().setItem(24, slot24);
            all.getInventory().setItem(25, slot25);
            all.getInventory().setItem(26, slot26);
            all.getInventory().setItem(27, slot27);
            all.getInventory().setItem(28, slot28);
            all.getInventory().setItem(29, slot29);
            all.getInventory().setItem(30, slot30);
            all.getInventory().setItem(31, slot31);
            all.getInventory().setItem(32, slot32);
            all.getInventory().setItem(33, slot33);
            all.getInventory().setItem(34, slot34);
            all.getInventory().setItem(35, slot35);
            all.getInventory().setItemInOffHand(offHand);
            all.getInventory().setHelmet(helmet);
            all.getInventory().setChestplate(chestplate);
            all.getInventory().setLeggings(leggings);
            all.getInventory().setBoots(boots);

        }
    }
}
