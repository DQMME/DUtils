package de.dqmme.dutils.listeners;

import de.dqmme.dutils.utils.GameruleUtils;
import de.dqmme.dutils.utils.Inventorys;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {
    private final Inventorys inventorys = new Inventorys();
    private final GameruleUtils gameruleUtils = new GameruleUtils();

    @EventHandler
    private void onInvClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        switch (e.getView().getTitle()) {
            case "§6Einstellungen §7- §6Home":
                if(e.getCurrentItem() != null) {
                    if(e.getCurrentItem().hasItemMeta()) {
                        if(e.getCurrentItem().getItemMeta().hasDisplayName()) {
                            switch (e.getCurrentItem().getItemMeta().getDisplayName()) {
                                case "§cChallenges":
                                    player.openInventory(inventorys.settingsChallenges());
                                    e.setCancelled(true);
                                    break;
                                case "§aGamerules":
                                    player.openInventory(inventorys.settingsGamerules());
                                    e.setCancelled(true);
                                    break;
                                default:
                                    e.setCancelled(true);
                                    break;
                            }
                        }
                    }
                }
                break;
            case "§6Home §7- §6Gamerules":
                if(e.getCurrentItem() != null) {
                    if(e.getCurrentItem().hasItemMeta()) {
                        if(e.getCurrentItem().getItemMeta().hasDisplayName()) {
                            switch (e.getCurrentItem().getItemMeta().getDisplayName()) {
                                case "§aSchwierigkeit":
                                    for(World worlds : Bukkit.getWorlds()) {
                                        if(gameruleUtils.getDifficulty().equals(Difficulty.PEACEFUL)) {
                                            gameruleUtils.setDifficulty(Difficulty.EASY);
                                            worlds.setDifficulty(Difficulty.EASY);
                                        } else if(gameruleUtils.getDifficulty().equals(Difficulty.EASY)) {
                                            gameruleUtils.setDifficulty(Difficulty.NORMAL);
                                            worlds.setDifficulty(Difficulty.NORMAL);
                                        } else if(gameruleUtils.getDifficulty().equals(Difficulty.NORMAL)) {
                                            gameruleUtils.setDifficulty(Difficulty.HARD);
                                            worlds.setDifficulty(Difficulty.HARD);
                                        } else if(gameruleUtils.getDifficulty().equals(Difficulty.HARD)) {
                                            gameruleUtils.setDifficulty(Difficulty.PEACEFUL);
                                            worlds.setDifficulty(Difficulty.PEACEFUL);
                                        }
                                    }
                                    e.setCancelled(true);
                                    break;
                                case "§aPvP":
                                    for(World worlds : Bukkit.getWorlds()) {
                                        gameruleUtils.setPvP(!gameruleUtils.getPvP());
                                        worlds.setPVP(!gameruleUtils.getPvP());
                                    }
                                    e.setCancelled(true);
                                    break;
                                case "§aSchadensnachrichten":
                                    gameruleUtils.setDamageMessages(!gameruleUtils.getDamageMessages());
                                    e.setCancelled(true);
                                    break;
                                case "§aSuppenheilung":
                                    gameruleUtils.setSoup(!gameruleUtils.getSoup());
                                    e.setCancelled(true);
                                    break;
                                case "§aGeteilte Leben":
                                    gameruleUtils.setSplitHealth(!gameruleUtils.getSplitHealth());
                                    e.setCancelled(true);
                                    break;
                                case "§aUltra-Hardcore":
                                    gameruleUtils.setUHC(!gameruleUtils.getUHC());
                                    for(World worlds : Bukkit.getWorlds()) {
                                        worlds.setGameRule(GameRule.NATURAL_REGENERATION, gameruleUtils.getUHC());
                                    }
                                    e.setCancelled(true);
                                    break;
                                case "§aUltra-Ultra-Hardcore":
                                    gameruleUtils.setUUHC(!gameruleUtils.getUUHC());
                                    e.setCancelled(true);
                                    break;
                                case "§aMaximale Leben":
                                    gameruleUtils.setMaxHealth(gameruleUtils.getMaxHealth() + 5);
                                    for(Player all : Bukkit.getOnlinePlayers()) {
                                        all.setMaxHealth(gameruleUtils.getMaxHealth());
                                    }
                                    break;
                                case "§c":
                                    player.openInventory(inventorys.settingsHome());
                                    e.setCancelled(true);
                                    break;
                                default:
                            }
                        }
                    }
                }
                break;
        }
    }
}
