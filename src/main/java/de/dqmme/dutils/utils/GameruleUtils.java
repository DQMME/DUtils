package de.dqmme.dutils.utils;

import de.dqmme.dutils.DUtils;
import org.bukkit.Difficulty;

import java.io.IOException;

public class GameruleUtils {
    //<>
    public void setDifficulty(String difficulty) {
        DUtils.getPlugin(DUtils.class).gamerulesConf.set("Difficulty", difficulty);
        DUtils.getPlugin(DUtils.class).saveFile(DUtils.getPlugin(DUtils.class).gamerulesConf, DUtils.getPlugin(DUtils.class).gamerules);
    }

    public Difficulty getDifficulty() {
        Difficulty difficulty = null;
        if(DUtils.getPlugin(DUtils.class).gamerulesConf.get("Difficulty") == null) {
            setDifficulty("NORMAL");
            difficulty = Difficulty.NORMAL;
        } else if(DUtils.getPlugin(DUtils.class).gamerulesConf.get("Difficulty").equals("PEACEFUL")) {
            difficulty = Difficulty.PEACEFUL;
        } else if(DUtils.getPlugin(DUtils.class).gamerulesConf.get("Difficulty").equals("EASY")) {
            difficulty = Difficulty.EASY;
        } else if(DUtils.getPlugin(DUtils.class).gamerulesConf.get("Difficulty").equals("NORMAL")) {
            difficulty = Difficulty.NORMAL;
        } else if(DUtils.getPlugin(DUtils.class).gamerulesConf.get("Difficulty").equals("HARD")) {
            difficulty = Difficulty.HARD;
        }
        return difficulty;
    }

    public void setPvP(boolean pvp) {
        DUtils.getPlugin(DUtils.class).gamerulesConf.set("PvP", pvp);
        DUtils.getPlugin(DUtils.class).saveFile(DUtils.getPlugin(DUtils.class).gamerulesConf, DUtils.getPlugin(DUtils.class).gamerules);
    }

    public boolean getPvP() {
        if(DUtils.getPlugin(DUtils.class).gamerulesConf.get("PvP") == null) {
            setPvP(true);
        }
        return DUtils.getPlugin(DUtils.class).gamerulesConf.getBoolean("PvP");
    }

    public void setDamageMessages(boolean damageMessages) {
        DUtils.getPlugin(DUtils.class).gamerulesConf.set("DamageMessages", damageMessages);
        DUtils.getPlugin(DUtils.class).saveFile(DUtils.getPlugin(DUtils.class).gamerulesConf, DUtils.getPlugin(DUtils.class).gamerules);
    }

    public boolean getDamageMessages() {
        if(DUtils.getPlugin(DUtils.class).gamerulesConf.get("DamageMessages") == null) {
            setDamageMessages(false);
        }
        return DUtils.getPlugin(DUtils.class).gamerulesConf.getBoolean("DamageMessages");
    }

    public void setSoup(boolean soup) {
        DUtils.getPlugin(DUtils.class).gamerulesConf.set("Soup", soup);
        DUtils.getPlugin(DUtils.class).saveFile(DUtils.getPlugin(DUtils.class).gamerulesConf, DUtils.getPlugin(DUtils.class).gamerules);
    }

    public boolean getSoup() {
        if(DUtils.getPlugin(DUtils.class).gamerulesConf.get("Soup") == null) {
            setSoup(false);
        }
        return DUtils.getPlugin(DUtils.class).gamerulesConf.getBoolean("Soup");
    }

    public void setSplitHealth(boolean splitHealth) {
        DUtils.getPlugin(DUtils.class).gamerulesConf.set("SplitHealth", splitHealth);
        DUtils.getPlugin(DUtils.class).saveFile(DUtils.getPlugin(DUtils.class).gamerulesConf, DUtils.getPlugin(DUtils.class).gamerules);
    }

    public boolean getSplitHealth() {
        if(DUtils.getPlugin(DUtils.class).gamerulesConf.get("SplitHealth") == null) {
            setSplitHealth(false);
        }
        return DUtils.getPlugin(DUtils.class).gamerulesConf.getBoolean("SplitHealth");
    }

    public void setUHC(boolean uhc) {
        DUtils.getPlugin(DUtils.class).gamerulesConf.set("NaturalRegeneration", uhc);
        DUtils.getPlugin(DUtils.class).saveFile(DUtils.getPlugin(DUtils.class).gamerulesConf, DUtils.getPlugin(DUtils.class).gamerules);
    }

    public boolean getUHC() {
        if(DUtils.getPlugin(DUtils.class).gamerulesConf.get("NaturalRegeneration") == null) {
            setUHC(true);
        }
        return DUtils.getPlugin(DUtils.class).gamerulesConf.getBoolean("NaturalRegeneration");
    }

    public void setUUHC(boolean uuhc) {
        DUtils.getPlugin(DUtils.class).gamerulesConf.set("UUHC", uuhc);
        DUtils.getPlugin(DUtils.class).saveFile(DUtils.getPlugin(DUtils.class).gamerulesConf, DUtils.getPlugin(DUtils.class).gamerules);
    }

    public boolean getUUHC() {
        if(DUtils.getPlugin(DUtils.class).gamerulesConf.get("UUHC") == null) {
            setUUHC(false);
        }
        return DUtils.getPlugin(DUtils.class).gamerulesConf.getBoolean("UUHC");
    }

    public void setMaxHealth(int hp) {
        if(hp < 50) {
            if(hp > 0) {
                DUtils.getPlugin(DUtils.class).gamerulesConf.set("MaxHealth", hp);
                DUtils.getPlugin(DUtils.class).saveFile(DUtils.getPlugin(DUtils.class).gamerulesConf, DUtils.getPlugin(DUtils.class).gamerules);
            }
        }
    }

    public int getMaxHealth() {
        if(DUtils.getPlugin(DUtils.class).gamerulesConf.get("MaxHealth") == null) {
            setMaxHealth(20);
        }
        return DUtils.getPlugin(DUtils.class).gamerulesConf.getInt("MaxHealth");
    }

}
