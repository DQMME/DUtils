package de.dqmme.dutils.listeners;

import de.dqmme.dutils.DUtils;
import de.dqmme.dutils.utils.*;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.RenderType;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class InventoryClickListener implements Listener {
    private final Inventorys inventorys = new Inventorys();
    private final GameruleUtils gameruleUtils = new GameruleUtils();
    private final Messages messages = new Messages();
    private final TimerUtils timerUtils = new TimerUtils();
    private final ConfigUtils configUtils = new ConfigUtils();
    private final ChallengeUtils challengeUtils = new ChallengeUtils();

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
            case "§6Settings §7- §6Gamerules":
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
                                case "§aHerzen im Tab":
                                    if(e.getClick().isLeftClick()) {
                                        gameruleUtils.setHealthInTab(!gameruleUtils.getHealthInTab());
                                    } else {
                                        if(gameruleUtils.getHealthInTabType().equals(RenderType.HEARTS)) {
                                            gameruleUtils.setHealthInTabType("INTEGER");
                                            player.sendMessage(messages.HEALTH_IN_TAB_TYPE_SET.replace("%HEALTH%", "Zahlen"));
                                        } else {
                                            gameruleUtils.setHealthInTabType("HEARTS");
                                            player.sendMessage(messages.HEALTH_IN_TAB_TYPE_SET.replace("%HEALTH%", "Herzen"));
                                        }
                                    }

                                    if(gameruleUtils.getHealthInTab()) {
                                        player.sendMessage(messages.HEALTH_IN_TAB_SET.replace("%HEALTH%", "aktiviert."));
                                    } else {
                                        player.sendMessage(messages.HEALTH_IN_TAB_SET.replace("%HEALTH%", "deaktiviert."));
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
            case "§6Settings §7- §6Challenges":
                if(e.getCurrentItem() != null) {
                    if(e.getCurrentItem().hasItemMeta()) {
                        if(e.getCurrentItem().getItemMeta().hasDisplayName()) {
                            switch (e.getCurrentItem().getItemMeta().getDisplayName()) {
                                case "§aRandom-Item":
                                    challengeUtils.setRandomItem(!challengeUtils.getRandomItem());

                                    World worldRandomItem = Bukkit.getWorld("world_random_item");
                                    World world = Bukkit.getWorld("world");

                                    if(challengeUtils.getRandomItem()) {
                                        if(worldRandomItem != null) {
                                            Location spawnLocation = worldRandomItem.getSpawnLocation();
                                            for(Player all : Bukkit.getOnlinePlayers()) {
                                                all.teleport(spawnLocation);
                                            }
                                        }
                                        DUtils.getPlugin(DUtils.class).runBar(DUtils.getPlugin(DUtils.class).bossBar);
                                        for(Player all : Bukkit.getOnlinePlayers()) {
                                            DUtils.getPlugin(DUtils.class).bossBar.addPlayer(all);
                                        }
                                        new BukkitRunnable() {
                                            @Override
                                            public void run() {
                                                if(challengeUtils.getRandomItem()) {
                                                    for(Player all : Bukkit.getOnlinePlayers()) {
                                                        addRandomItem(all);
                                                    }
                                                } else {
                                                    cancel();
                                                }
                                            }
                                        }.runTaskTimerAsynchronously(DUtils.getPlugin(DUtils.class), 0, 10*20);
                                        player.sendMessage(messages.CHALLANGE_SET.replace("%CHALLENGE%", "Random-Item").replace("%STATUS%", "§aaktiviert"));
                                        timerUtils.startTimer();
                                        player.sendMessage(messages.TIMER_STARTED);
                                    } else {
                                        for(Player all : Bukkit.getOnlinePlayers()) {
                                            if(all.getLocation().getWorld().equals(worldRandomItem)) {
                                                if(world != null) {
                                                    all.teleport(world.getSpawnLocation());
                                                }
                                            }
                                        }
                                        player.sendMessage(messages.CHALLANGE_SET.replace("%CHALLENGE%", "Random-Item").replace("%STATUS%", "§cdeaktiviert"));
                                    }
                                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 20, 1);
                                    player.openInventory(inventorys.settingsChallenges());
                                    e.setCancelled(true);
                                    break;
                                case "§aInventory-Sync":
                                    challengeUtils.setInvSync(!challengeUtils.getInvSync());

                                    if(challengeUtils.getRandomItem()) {
                                        for(Player all : Bukkit.getOnlinePlayers()) {
                                            all.getInventory().clear();
                                        }
                                    }

                                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 20, 1);
                                    player.openInventory(inventorys.settingsChallenges());
                                    e.setCancelled(true);
                                    break;
                                case "§c":
                                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 20, 1);
                                    player.openInventory(inventorys.settingsHome());
                                    e.setCancelled(true);
                                    break;
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
                                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 20, 1);
                                    player.closeInventory();
                                    e.setCancelled(true);
                                    break;
                                case "§aWelten resetten":
                                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 20, 1);
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
            case "§6DUtils §7- §6Timer":
                if(e.getCurrentItem() != null) {
                    if(e.getCurrentItem().hasItemMeta()) {
                        if(e.getCurrentItem().getItemMeta().hasDisplayName()) {
                            switch (e.getCurrentItem().getItemMeta().getDisplayName()) {
                                case "§cTimer stoppen":
                                    timerUtils.stopTimer();
                                    player.sendMessage(messages.TIMER_PAUSED);
                                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 20, 1);
                                    e.setCancelled(true);
                                    break;
                                case "§aTimer starten":
                                    timerUtils.startTimer();
                                    player.sendMessage(messages.TIMER_STARTED);
                                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 20, 1);
                                    e.setCancelled(true);
                                    break;
                                case "§eTimer zurücksetzen":
                                    timerUtils.resetTimer();
                                    player.sendMessage(messages.TIMER_RESETTED);
                                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 20, 1);
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

        if(challengeUtils.getInvSync()) {
            Bukkit.getScheduler().runTaskLater(DUtils.getPlugin(DUtils.class), () -> {
                syncInventory(player);
            }, 10);
        }
    }

    public void addRandomItem(Player player) {
        if(challengeUtils.getRandomItem()) {
            Random random = new Random();
            List<Material> materials = Arrays.asList(Material.values());
            Material randomMaterial = materials.get(random.nextInt(materials.size()));
            if(player.getInventory().firstEmpty() != -1) {
                player.getInventory().addItem(new ItemStack(randomMaterial));
            } else {
                player.getWorld().dropItemNaturally(player.getLocation(), new ItemStack(randomMaterial));
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
