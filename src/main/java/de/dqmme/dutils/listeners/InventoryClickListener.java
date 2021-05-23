package de.dqmme.dutils.listeners;

import de.dqmme.dutils.utils.ConfigUtils;
import de.dqmme.dutils.utils.GameruleUtils;
import de.dqmme.dutils.utils.Inventorys;
import de.dqmme.dutils.utils.Messages;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {
    private final Inventorys inventorys = new Inventorys();
    private final GameruleUtils gameruleUtils = new GameruleUtils();
    private final Messages messages = new Messages();
    private final ConfigUtils configUtils = new ConfigUtils();

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
                                    if(gameruleUtils.getDifficulty().equals(Difficulty.PEACEFUL)) {
                                        if(e.getClick().isLeftClick()) {
                                            for(World worlds : Bukkit.getWorlds()) {
                                                worlds.setDifficulty(Difficulty.EASY);
                                            }
                                            gameruleUtils.setDifficulty("EASY");
                                            player.sendMessage(messages.DIFFICULTY_SET.replace("%DIFFICULTY%", "EASY"));
                                        } else {
                                            for(World worlds : Bukkit.getWorlds()) {
                                                worlds.setDifficulty(Difficulty.HARD);
                                            }
                                            gameruleUtils.setDifficulty("HARD");
                                            player.sendMessage(messages.DIFFICULTY_SET.replace("%DIFFICULTY%", "HARD"));
                                        }
                                    } else if(gameruleUtils.getDifficulty().equals(Difficulty.EASY)) {
                                        if(e.getClick().isLeftClick()) {
                                            gameruleUtils.setDifficulty("NORMAL");
                                            player.sendMessage(messages.DIFFICULTY_SET.replace("%DIFFICULTY%", "NORMAL"));
                                            for(World worlds : Bukkit.getWorlds()) {
                                                worlds.setDifficulty(Difficulty.NORMAL);
                                            }
                                        } else {
                                            gameruleUtils.setDifficulty("PEACEFUL");
                                            player.sendMessage(messages.DIFFICULTY_SET.replace("%DIFFICULTY%", "PEACEFUL"));
                                            for(World worlds : Bukkit.getWorlds()) {
                                                worlds.setDifficulty(Difficulty.PEACEFUL);
                                            }
                                        }
                                    } else if(gameruleUtils.getDifficulty().equals(Difficulty.NORMAL)) {
                                        if(e.getClick().isLeftClick()) {
                                            gameruleUtils.setDifficulty("HARD");
                                            player.sendMessage(messages.DIFFICULTY_SET.replace("%DIFFICULTY%", "HARD"));
                                            for(World worlds : Bukkit.getWorlds()) {
                                                worlds.setDifficulty(Difficulty.HARD);
                                            }
                                        } else {
                                            gameruleUtils.setDifficulty("EASY");
                                            player.sendMessage(messages.DIFFICULTY_SET.replace("%DIFFICULTY%", "EASY"));
                                            for(World worlds : Bukkit.getWorlds()) {
                                                worlds.setDifficulty(Difficulty.EASY);
                                            }
                                        }
                                    } else if(gameruleUtils.getDifficulty().equals(Difficulty.HARD)) {
                                        if(e.getClick().isLeftClick()) {
                                            gameruleUtils.setDifficulty("PEACEFUL");
                                            player.sendMessage(messages.DIFFICULTY_SET.replace("%DIFFICULTY%", "PEACEFUL"));
                                            for(World worlds : Bukkit.getWorlds()) {
                                                worlds.setDifficulty(Difficulty.PEACEFUL);
                                            }
                                        } else {
                                            gameruleUtils.setDifficulty("NORMAL");
                                            player.sendMessage(messages.DIFFICULTY_SET.replace("%DIFFICULTY%", "NORMAL"));
                                            for(World worlds : Bukkit.getWorlds()) {
                                                worlds.setDifficulty(Difficulty.NORMAL);
                                            }
                                        }
                                    }
                                    player.openInventory(inventorys.settingsGamerules());
                                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 20, 1);
                                    e.setCancelled(true);
                                    break;
                                case "§aPvP":
                                    gameruleUtils.setPvP(!gameruleUtils.getPvP());
                                    for(World worlds : Bukkit.getWorlds()) {
                                        worlds.setPVP(!gameruleUtils.getPvP());
                                    }
                                    if(gameruleUtils.getPvP()) {
                                        player.sendMessage(messages.PVP_SET.replace("%PVP%", "aktiviert"));
                                    } else {
                                        player.sendMessage(messages.PVP_SET.replace("%PVP%", "deaktiviert"));
                                    }
                                    player.openInventory(inventorys.settingsGamerules());
                                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 20, 1);
                                    e.setCancelled(true);
                                    break;
                                case "§aSchadensnachrichten":
                                    gameruleUtils.setDamageMessages(!gameruleUtils.getDamageMessages());
                                    if(gameruleUtils.getDamageMessages()) {
                                        player.sendMessage(messages.DAMAGE_MESSAGES_SET.replace("%MESSAGES%", "aktiviert"));
                                    } else {
                                        player.sendMessage(messages.DAMAGE_MESSAGES_SET.replace("%MESSAGES%", "deaktiviert"));
                                    }
                                    player.openInventory(inventorys.settingsGamerules());
                                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 20, 1);
                                    e.setCancelled(true);
                                    break;
                                case "§aSuppenheilung":
                                    gameruleUtils.setSoup(!gameruleUtils.getSoup());
                                    if(gameruleUtils.getSoup()) {
                                        player.sendMessage(messages.SOUP_SET.replace("%SOUP%", "aktiviert"));
                                    } else {
                                        player.sendMessage(messages.SOUP_SET.replace("%SOUP%", "deaktiviert"));
                                    }
                                    player.openInventory(inventorys.settingsGamerules());
                                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 20, 1);
                                    e.setCancelled(true);
                                    break;
                                case "§aGeteilte Leben":
                                    gameruleUtils.setSplitHealth(!gameruleUtils.getSplitHealth());
                                    if(gameruleUtils.getSplitHealth()) {
                                        player.sendMessage(messages.SPLIT_HEALTH_SET.replace("%SPLIT%", "aktiviert"));
                                    } else {
                                        player.sendMessage(messages.SPLIT_HEALTH_SET.replace("%SPLIT%", "deaktiviert"));
                                    }
                                    player.openInventory(inventorys.settingsGamerules());
                                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 20, 1);
                                    e.setCancelled(true);
                                    break;
                                case "§aUltra-Hardcore":
                                    gameruleUtils.setUHC(!gameruleUtils.getUHC());
                                    for(World worlds : Bukkit.getWorlds()) {
                                        worlds.setGameRule(GameRule.NATURAL_REGENERATION, gameruleUtils.getUHC());
                                    }
                                    if(gameruleUtils.getUHC()) {
                                        player.sendMessage(messages.UHC_SET.replace("%UHC%", "aktiviert"));
                                    } else {
                                        player.sendMessage(messages.UHC_SET.replace("%UHC%", "deaktiviert"));
                                    }
                                    player.openInventory(inventorys.settingsGamerules());
                                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 20, 1);
                                    e.setCancelled(true);
                                    break;
                                case "§aUltra-Ultra-Hardcore":
                                    gameruleUtils.setUUHC(!gameruleUtils.getUUHC());
                                    if(gameruleUtils.getUUHC()) {
                                        player.sendMessage(messages.UUHC_SET.replace("%UUHC%", "deaktiviert"));
                                    } else {
                                        player.sendMessage(messages.UUHC_SET.replace("%UUHC%", "aktiviert"));
                                    }
                                    player.openInventory(inventorys.settingsGamerules());
                                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 20, 1);
                                    e.setCancelled(true);
                                    break;
                                case "§aMaximale Leben":
                                    if(e.getClick().isLeftClick()) {
                                        gameruleUtils.setMaxHealth(gameruleUtils.getMaxHealth() + 2);
                                        player.sendMessage(messages.MAX_HEALTH_SET.replace("%HEALTH%", gameruleUtils.getMaxHealth() + ""));
                                        for(Player all : Bukkit.getOnlinePlayers()) {
                                            all.setMaxHealth(gameruleUtils.getMaxHealth());
                                        }
                                    } else if(e.getClick().isRightClick()) {
                                        if(gameruleUtils.getMaxHealth() == 2) {
                                            gameruleUtils.setMaxHealth(1);
                                        } else {
                                            gameruleUtils.setMaxHealth(gameruleUtils.getMaxHealth() - 2);
                                        }
                                        player.sendMessage(messages.MAX_HEALTH_SET.replace("%HEALTH%", gameruleUtils.getMaxHealth() + ""));
                                        for(Player all : Bukkit.getOnlinePlayers()) {
                                            all.setMaxHealth(gameruleUtils.getMaxHealth());
                                        }
                                    }
                                    player.openInventory(inventorys.settingsGamerules());
                                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 20, 1);
                                    e.setCancelled(true);
                                    break;
                                case "§c":
                                    player.openInventory(inventorys.settingsHome());
                                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 20, 1);
                                    e.setCancelled(true);
                                    break;
                                default:
                            }
                        }
                    }
                }
                break;
            case "§6DUtils §7- §6Reset":
                if(e.getCurrentItem() != null) {
                    if(e.getCurrentItem().hasItemMeta()) {
                        if(e.getCurrentItem().getItemMeta().hasDisplayName()) {
                            switch (e.getCurrentItem().getItemMeta().getDisplayName()) {
                                case "§cAbbrechen":
                                    player.closeInventory();
                                    e.setCancelled(true);
                                    break;
                                case "§aWelten resetten":
                                    configUtils.setReset(true);
                                    for(Player all : Bukkit.getOnlinePlayers()) {
                                        all.kickPlayer("§8§l§m              §r§8[§6DUtils §7- §6Reset§8]§m§l              " +
                                                "\n" +
                                                "§e§l" + player.getName() + " §7hat einen Welten-Reset veranlasst." +
                                                "\n" +
                                                "§7Der Server sollte in §ec.a. 1 Minute §7wieder erreichbar sein." +
                                                "\n" +
                                                "§8§m§l                                           ");
                                    }
                                    System.out.println(configUtils.getReset());
                                    Bukkit.getServer().spigot().restart();
                                    player.closeInventory();
                                    e.setCancelled(true);
                                    break;
                                case "§c":
                                    e.setCancelled(true);
                                    break;
                            }
                        }
                    }
                }
                break;
        }
    }
}
