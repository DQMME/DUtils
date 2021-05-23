package de.dqmme.dutils;

import de.dqmme.dutils.commands.DUtilsCommand;
import de.dqmme.dutils.commands.ResetCommand;
import de.dqmme.dutils.commands.SettingsCommand;
import de.dqmme.dutils.listeners.*;
import de.dqmme.dutils.utils.ConfigUtils;
import de.dqmme.dutils.utils.GameruleUtils;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

public final class DUtils extends JavaPlugin {

    public File config = new File(getDataFolder(), "Config.yml");
    public YamlConfiguration configConf = YamlConfiguration.loadConfiguration(config);

    public File gamerules = new File(getDataFolder(), "Gamerules.yml");
    public YamlConfiguration gamerulesConf = YamlConfiguration.loadConfiguration(gamerules);

    private final GameruleUtils gameruleUtils = new GameruleUtils();
    private final ConfigUtils configUtils = new ConfigUtils();

    @Override
    public void onEnable() {
        registerCommands();
        listenerRegistration();

        saveFile(gamerulesConf, gamerules);
        saveFile(configConf, config);


        for(World worlds : Bukkit.getWorlds()) {
            worlds.setGameRule(GameRule.NATURAL_REGENERATION, gameruleUtils.getUHC());
            worlds.setPVP(gameruleUtils.getPvP());
            if(gameruleUtils.getDifficulty() == null) {
                worlds.setDifficulty(Difficulty.NORMAL);
                worlds.setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
            } else {
                worlds.setDifficulty(gameruleUtils.getDifficulty());
                worlds.setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
            }
        }
    }

    @Override
    public void onDisable() {
        if(configUtils.getReset()) {
            World world = Bukkit.getWorld("world");
            World nether = Bukkit.getWorld("world_nether");
            World end = Bukkit.getWorld("world_the_end");
            try {
                Files.walk(world.getWorldFolder().toPath())
                        .sorted(Comparator.reverseOrder())
                        .map(Path::toFile)
                        .forEach(File::delete);
                Files.walk(nether.getWorldFolder().toPath())
                        .sorted(Comparator.reverseOrder())
                        .map(Path::toFile)
                        .forEach(File::delete);
                Files.walk(end.getWorldFolder().toPath())
                        .sorted(Comparator.reverseOrder())
                        .map(Path::toFile)
                        .forEach(File::delete);
                configUtils.setReset(false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void registerCommands() {
        getCommand("settings").setExecutor(new SettingsCommand());
        getCommand("dutils").setExecutor(new DUtilsCommand());
        getCommand("reset").setExecutor(new ResetCommand());
    }

    public void listenerRegistration() {
        PluginManager p = Bukkit.getPluginManager();
        p.registerEvents(new HitListener(), this);
        p.registerEvents(new JoinListener(), this);
        p.registerEvents(new DamageListener(), this);
        p.registerEvents(new InteractListener(), this);
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

    public void initGameRule() {
        saveFile(gamerulesConf, gamerules);
    }
}
