package de.dqmme.dutils.utils;

import de.dqmme.dutils.DUtils;
import org.bukkit.Difficulty;

import java.io.IOException;

public class GameruleUtils {
    //<>
    private DUtils main = new DUtils();

    public void setDifficulty(Difficulty difficulty) {
        main.gamerulesConf.set("Gamerules." + "Difficulty.", difficulty);
        main.saveFile(main.gamerulesConf, main.gamerules);
    }

    public Difficulty getDifficulty() {
        return (Difficulty) main.gamerulesConf.get("Gamerules." + "Difficulty.");
    }

    public void setPvP(boolean pvp) {
        main.gamerulesConf.set("Gamerules." + "PvP.", pvp);
        main.saveFile(main.gamerulesConf, main.gamerules);
    }

    public boolean getPvP() {
        return main.gamerulesConf.getBoolean("Gamerules." + "PvP.");
    }

    public void setDamageMessages(boolean damageMessages) {
        main.gamerulesConf.set("Gamerules." + "DamageMessages.", damageMessages);
        main.saveFile(main.gamerulesConf, main.gamerules);
    }

    public boolean getDamageMessages() {
        return main.gamerulesConf.getBoolean("Gamerules." + "DamageMessages.");
    }

    public void setSoup(boolean soup) {
        main.gamerulesConf.set("Gamerules." + "Soup.", soup);
        main.saveFile(main.gamerulesConf, main.gamerules);
    }

    public boolean getSoup() {
        return main.gamerulesConf.getBoolean("Gamerules." + "Soup.");
    }

    public void setSplitHealth(boolean splitHealth) {
        main.gamerulesConf.set("Gamerules." + "Soup.", splitHealth);
        main.saveFile(main.gamerulesConf, main.gamerules);
    }

    public boolean getSplitHealth() {
        return main.gamerulesConf.getBoolean("Gamerules." + "Soup.");
    }

    public void setUHC(boolean uhc) {
        main.gamerulesConf.set("Gamerules." + "UHC.", uhc);
        main.saveFile(main.gamerulesConf, main.gamerules);
    }

    public boolean getUHC() {
        return main.gamerulesConf.getBoolean("Gamerules." + "UHC.");
    }

    public void setUUHC(boolean uuhc) {
        main.gamerulesConf.set("Gamerules." + "UUHC.", uuhc);
        main.saveFile(main.gamerulesConf, main.gamerules);
    }

    public boolean getUUHC() {
        return main.gamerulesConf.getBoolean("Gamerules." + "UUHC.");
    }

    public void setMaxHealth(int hp) {
        if(hp < 50) {
            if(hp > 0) {
                main.gamerulesConf.set("Gamerules." + "MaxHealth.", hp);
                main.saveFile(main.gamerulesConf, main.gamerules);
            }
        }
    }

    public int getMaxHealth() {
        return main.gamerulesConf.getInt("Gamerules." + "MaxHealth.");
    }

}
