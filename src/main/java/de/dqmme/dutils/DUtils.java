package de.dqmme.dutils;

import de.dqmme.dutils.autocomplete.DUtilsComplete;
import de.dqmme.dutils.autocomplete.ResetComplete;
import de.dqmme.dutils.autocomplete.SettingsComplete;
import de.dqmme.dutils.autocomplete.TimerComplete;
import de.dqmme.dutils.commands.DUtilsCommand;
import de.dqmme.dutils.commands.ResetCommand;
import de.dqmme.dutils.commands.SettingsCommand;
import de.dqmme.dutils.commands.TimerCommand;
import de.dqmme.dutils.listeners.*;
import de.dqmme.dutils.utils.*;
import org.bukkit.*;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public final class DUtils extends JavaPlugin {

    public File timer = new File(getDataFolder(), "Timer.yml");
    public YamlConfiguration timerConf = YamlConfiguration.loadConfiguration(timer);

    public File config = new File(getDataFolder(), "Config.yml");
    public YamlConfiguration configConf = YamlConfiguration.loadConfiguration(config);


    public File gamerules = new File(getDataFolder(), "Gamerules.yml");
    public YamlConfiguration gamerulesConf = YamlConfiguration.loadConfiguration(gamerules);

    public File challenges = new File(getDataFolder(), "Challenges.yml");
    public YamlConfiguration challengesConf = YamlConfiguration.loadConfiguration(challenges);


    private final TimerUtils timerUtils = new TimerUtils();
    private final ConfigUtils configUtils = new ConfigUtils();
    private final GameruleUtils gameruleUtils = new GameruleUtils();
    private final ChallengeUtils challengeUtils = new ChallengeUtils();

    public BossBar bossBar = Bukkit.createBossBar("dummy", BarColor.YELLOW, BarStyle.SOLID);

    @Override
    public void onEnable() {
        getLogger().info("§7[§6DUtil-Debug§7] §7Registering Commands.");
        commandRegistration();
        tabCompleterRegistration();
        getLogger().info("§7[§6DUtil-Debug§7] §7Registering Commands complete.");
        getLogger().info("§7[§6DUtil-Debug§7] §7Registering Listeners.");
        listenerRegistration();
        getLogger().info("§7[§6DUtil-Debug§7] §7Registering Listeners complete.");

        getLogger().info("§7[§6DUtil-Debug§7] §7Loading Files.");
        saveFile(timerConf, timer);
        saveFile(configConf, config);
        saveFile(gamerulesConf, gamerules);
        saveFile(challengesConf, challenges);
        getLogger().info("§7[§6DUtil-Debug§7] §7Loading Files complete.");

        getLogger().info("§7[§6DUtil-Debug§7] §7Setting Gamerules.");
        for (World worlds : Bukkit.getWorlds()) {
            worlds.setGameRule(GameRule.NATURAL_REGENERATION, gameruleUtils.getUHC());
            worlds.setPVP(gameruleUtils.getPvP());
            if (gameruleUtils.getDifficulty() == null) {
                worlds.setDifficulty(Difficulty.NORMAL);
                worlds.setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
            } else {
                worlds.setDifficulty(gameruleUtils.getDifficulty());
                worlds.setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
            }
        }
        getLogger().info("§7[§6DUtil-Debug§7] §7Setting Gamerules complete.");

        World worldRandomItem = Bukkit.getWorld("world_random_item");

        if(worldRandomItem == null) {
            getLogger().info("§7[§6DUtil-Debug§7] §7Creating World world_random_Item.");
            WorldCreator worldCreator = new WorldCreator("world_random_item");
            worldCreator.generator(new EmptyChunkGenerator());
            worldCreator.createWorld();
            getLogger().info("§7[§6DUtil-Debug§7] §7Creating World world_random_Item complete.");
        }

        if (worldRandomItem != null) {
            Location newSpawn = new Location(worldRandomItem, 0.5, 65, 0.5);
            worldRandomItem.setSpawnLocation(newSpawn);
            Location spawnLocation = worldRandomItem.getSpawnLocation();
            spawnLocation.getBlock().setType(Material.BEDROCK);
        }

        if(challengeUtils.getRandomItem()) {
            runBar(bossBar);
        }

        if(timerUtils.isRunning()) {
            timerUtils.startTimer();
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
        }.runTaskTimerAsynchronously(this, 0, 10*20);

        for(Player all : Bukkit.getOnlinePlayers()) {
            addRandomItem(all);
        }
    }

    @Override
    public void onDisable() {
        if(configUtils.getReset()) {
            getLogger().info("§7[§6DUtil-Debug§7] §7Removing Random-Item World complete.");
            World world = Bukkit.getWorld("world");
            World nether = Bukkit.getWorld("world_nether");
            World end = Bukkit.getWorld("world_the_end");
            World worldRandomItem = Bukkit.getWorld("world_random_item");
            try {
                getLogger().info("§7[§6DUtil-Debug§7] §7Removing World world.");
                Files.walk(world.getWorldFolder().toPath())
                        .sorted(Comparator.reverseOrder())
                        .map(Path::toFile)
                        .forEach(File::delete);
                getLogger().info("§7[§6DUtil-Debug§7] §7Removing World world complete.");
                getLogger().info("§7[§6DUtil-Debug§7] §7Removing World world_nether.");
                Files.walk(nether.getWorldFolder().toPath())
                        .sorted(Comparator.reverseOrder())
                        .map(Path::toFile)
                        .forEach(File::delete);
                getLogger().info("§7[§6DUtil-Debug§7] §7Removing World world_nether complete.");
                getLogger().info("§7[§6DUtil-Debug§7] §7Removing World world_the_end.");
                Files.walk(end.getWorldFolder().toPath())
                        .sorted(Comparator.reverseOrder())
                        .map(Path::toFile)
                        .forEach(File::delete);
                getLogger().info("§7[§6DUtil-Debug§7] §7Removing World world_the_end complete.");
                getLogger().info("§7[§6DUtil-Debug§7] §7Removing World world_random_Item.");
                Files.walk(worldRandomItem.getWorldFolder().toPath())
                        .sorted(Comparator.reverseOrder())
                        .map(Path::toFile)
                        .forEach(File::delete);
                getLogger().info("§7[§6DUtil-Debug§7] §7Removing World world_random_Item complete.");
                configUtils.setReset(false);
            } catch (IOException e) {
                e.printStackTrace();
            }

            timerUtils.saveTime();
        }
    }

    public void commandRegistration() {
        getCommand("timer").setExecutor(new TimerCommand());
        getCommand("reset").setExecutor(new ResetCommand());
        getCommand("dutils").setExecutor(new DUtilsCommand());
        getCommand("settings").setExecutor(new SettingsCommand());
    }

    public void tabCompleterRegistration() {
        getCommand("timer").setTabCompleter(new TimerComplete());
        getCommand("reset").setTabCompleter(new ResetComplete());
        getCommand("dutils").setTabCompleter(new DUtilsComplete());
        getCommand("settings").setTabCompleter(new SettingsComplete());
    }

    public void listenerRegistration() {
        PluginManager p = Bukkit.getPluginManager();
        p.registerEvents(new HitListener(), this);
        p.registerEvents(new SwapListener(), this);
        p.registerEvents(new JoinListener(), this);
        p.registerEvents(new QuitListener(), this);
        p.registerEvents(new DropListener(), this);
        p.registerEvents(new DeathListener(), this);
        p.registerEvents(new DamageListener(), this);
        p.registerEvents(new CollectListener(), this);
        p.registerEvents(new RespawnListener(), this);
        p.registerEvents(new ConsumeListener(), this);
        p.registerEvents(new InteractListener(), this);
        p.registerEvents(new BlockBreakListener(), this);
        p.registerEvents(new BlockPlaceListener(), this);
        p.registerEvents(new RegenerationListener(), this);
        p.registerEvents(new InventoryClickListener(), this);
    }

    public void saveFile(YamlConfiguration conf, File file) {
        try {
            conf.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void runBar(BossBar bar) {
        new BukkitRunnable() {
            int i = 1;

            @Override
            public void run() {
                if(challengeUtils.getRandomItem()) {
                    List<Double> progress = new ArrayList<>();
                    progress.add(0.1);
                    progress.add(0.2);
                    progress.add(0.3);
                    progress.add(0.4);
                    progress.add(0.5);
                    progress.add(0.6);
                    progress.add(0.7);
                    progress.add(0.8);
                    progress.add(0.9);
                    progress.add(1.0);

                    List<String> titles = new ArrayList<>();
                    titles.add("Nächstes Item: 9 Sekunden");
                    titles.add("Nächstes Item: 8 Sekunden");
                    titles.add("Nächstes Item: 7 Sekunden");
                    titles.add("Nächstes Item: 6 Sekunden");
                    titles.add("Nächstes Item: 5 Sekunden");
                    titles.add("Nächstes Item: 4 Sekunden");
                    titles.add("Nächstes Item: 3 Sekunden");
                    titles.add("Nächstes Item: 2 Sekunden");
                    titles.add("Nächstes Item: 1 Sekunden");
                    titles.add("Nächstes Item: 0 Sekunden");

                    bar.setTitle(titles.get(i));
                    bar.setProgress(progress.get(i));
                    i++;
                    if (i >= progress.size()){
                        i = 0;
                    }
                } else {
                    for(Player toRemove : bar.getPlayers()) {
                        bar.removePlayer(toRemove);
                    }
                    cancel();
                }
            }
        }.runTaskTimerAsynchronously(DUtils.getPlugin(DUtils.class), 20, 20);
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
}
