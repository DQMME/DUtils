package de.dqmme.dutils;

import de.dqmme.dutils.commands.Settings;
import de.dqmme.dutils.listeners.*;
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

public final class DUtils extends JavaPlugin {

    public File gamerules = new File(getDataFolder(), "Gamerules.yml");
    public YamlConfiguration gamerulesConf = YamlConfiguration.loadConfiguration(gamerules);

    private final GameruleUtils gameruleUtils = new GameruleUtils();

    @Override
    public void onEnable() {
        registerCommands();
        listenerRegistration();

        saveFile(gamerulesConf, gamerules);


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
       // if(!System.getProperty("java.version").startsWith("11")) {


      //  }
    }

    @Override
    public void onDisable() {
    }

    public void registerCommands() {
        getCommand("settings").setExecutor(new Settings());
        getCommand("dutils").setExecutor(new de.dqmme.dutils.commands.DUtils());
    }

    public void listenerRegistration() {
        PluginManager p = Bukkit.getPluginManager();
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
