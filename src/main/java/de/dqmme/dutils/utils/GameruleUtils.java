package de.dqmme.dutils.utils;

import de.dqmme.dutils.DUtils;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.RenderType;

import java.io.IOException;

public class GameruleUtils {
    //<>
    public void setDifficulty(String difficulty) {
        if(difficulty.equalsIgnoreCase("PEACEFUL")) {
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§7Schwierigkeit §7zu §ePEACEFUL §7gesetzt.", "§7Die Schwierigkeit ist jetzt §ePEACEFUL§7.", 5, 60, 5);
            }
        } else if(difficulty.equalsIgnoreCase("EASY")) {
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§7Schwierigkeit §7zu §eEASY §7gesetzt.", "§7Die Schwierigkeit ist jetzt §eEASY§7.", 5, 60, 5);
            }
        } else if(difficulty.equalsIgnoreCase("NORMAL")) {
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§7Schwierigkeit §7zu §eNORMAL §7gesetzt.", "§7Die Schwierigkeit ist jetzt §eNORMAL§7.", 5, 60, 5);
            }
        } else if(difficulty.equalsIgnoreCase("HARD")) {
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§7Schwierigkeit §7zu §eHARD §7gesetzt.", "§7Die Schwierigkeit ist jetzt §eHARD§7.", 5, 60, 5);
            }
        }
        DUtils.getPlugin(DUtils.class).gamerulesConf.set("Difficulty", difficulty);
        DUtils.getPlugin(DUtils.class).saveFile(DUtils.getPlugin(DUtils.class).gamerulesConf, DUtils.getPlugin(DUtils.class).gamerules);
    }

    public Difficulty getDifficulty() {
        Difficulty difficulty = null;
        if(DUtils.getPlugin(DUtils.class).gamerulesConf.get("Difficulty") == null) {
            setDifficulty("NORMAL");
            difficulty = Difficulty.NORMAL;
        } else if(DUtils.getPlugin(DUtils.class).gamerulesConf.getString("Difficulty").equalsIgnoreCase("PEACEFUL")) {
            difficulty = Difficulty.PEACEFUL;
        } else if(DUtils.getPlugin(DUtils.class).gamerulesConf.getString("Difficulty").equalsIgnoreCase("EASY")) {
            difficulty = Difficulty.EASY;
        } else if(DUtils.getPlugin(DUtils.class).gamerulesConf.getString("Difficulty").equalsIgnoreCase("NORMAL")) {
            difficulty = Difficulty.NORMAL;
        } else if(DUtils.getPlugin(DUtils.class).gamerulesConf.getString("Difficulty").equalsIgnoreCase("HARD")) {
            difficulty = Difficulty.HARD;
        }
        return difficulty;
    }

    public void setPvP(boolean pvp) {
        if(pvp) {
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§ePvP §aaktiviert.", "§7Das §ePvP §7ist jetzt §aktiviert§7.", 5, 60, 5);
            }
        } else {
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§ePvP §cdeaktiviert.", "§7Das §ePvP §7ist jetzt §cdeaktiviert§7.", 5, 60, 5);
            }
        }
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
        if(damageMessages) {
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§eSchadensnachrichten §aaktiviert.", "§7Die §eSchadensnachrichten §7sind jetzt §aktiviert§7.", 5, 60, 5);
            }
        } else {
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§eSchadensnachrichten §cdeaktiviert.", "§7Die §eSchadensnachrichten §7sind jetzt §cdeaktiviert§7.", 5, 60, 5);
            }
        }
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
        if(soup) {
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§eSuppenheilung §aaktiviert.", "§7Die §eSuppenheilung §7ist jetzt §aktiviert§7.", 5, 60, 5);
            }
        } else {
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§eSuppenheilung §cdeaktiviert.", "§7Die §eSuppenheilung §7ist jetzt §cdeaktiviert§7.", 5, 60, 5);
            }
        }
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
        if(splitHealth) {
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§eGeteilte Leben §aaktiviert.", "§7Die §eGeteilten Leben §7sind jetzt §aktiviert§7.", 5, 60, 5);
            }
        } else {
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§eGeteilte Leben §cdeaktiviert.", "§7Die §eGeteilten Leben §7sind jetzt §cdeaktiviert§7.", 5, 60, 5);
            }
        }
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
        if(uhc) {
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§eNatürliche Regeneration §aaktiviert.", "§7Die §eNatürliche Regeneration §7ist jetzt §aktiviert§7.", 5, 60, 5);
            }
        } else {
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§eNatürliche Regeneration §cdeaktiviert.", "§7Die §eNatürliche Regeneration §7ist jetzt §cdeaktiviert§7.", 5, 60, 5);
            }
        }
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
        if(uuhc) {
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§eKomplette Regeneration §cdeaktiviert.", "§7Die §eKomplette Regeneration §7ist jetzt §cdeaktiviert§7.", 5, 60, 5);
            }
        } else {
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.sendTitle("§eKomplette Regeneration §aaktiviert.", "§7Die §eKomplette Regeneration §7ist jetzt §aaktiviert§7.", 5, 60, 5);
            }
        }

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
                for(Player all : Bukkit.getOnlinePlayers()) {
                    all.sendTitle("§eMaximale Leben §7auf §c" + hp + "HP§7/§c " + hp/2 + " Herzen §7gesetzt.", "§7Die §eMaximalen Leben §7wurden auf §c" + hp + "HP§7/§c " + hp/2 + " Herzen §7gesetzt.", 5, 60, 5);
                }
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

    public void setHealthInTab(boolean healthInTab) {
        DUtils.getPlugin(DUtils.class).gamerulesConf.set("HealthInTab", healthInTab);
        DUtils.getPlugin(DUtils.class).saveFile(DUtils.getPlugin(DUtils.class).gamerulesConf, DUtils.getPlugin(DUtils.class).gamerules);
    }

    public void setHealthInTabType(String renderType) {
        DUtils.getPlugin(DUtils.class).gamerulesConf.set("HealthInTabType", renderType);
        DUtils.getPlugin(DUtils.class).saveFile(DUtils.getPlugin(DUtils.class).gamerulesConf, DUtils.getPlugin(DUtils.class).gamerules);
    }

    public boolean getHealthInTab() {
        if(DUtils.getPlugin(DUtils.class).gamerulesConf.get("HealthInTab") == null) {
            return true;
        } else {
            return DUtils.getPlugin(DUtils.class).gamerulesConf.getBoolean("HealthInTab");
        }
    }

    public RenderType getHealthInTabType() {
        RenderType renderType;
        if(DUtils.getPlugin(DUtils.class).gamerulesConf.get("HealthInTabType") == null) {
            setHealthInTabType("HEARTS");
        }
        if(DUtils.getPlugin(DUtils.class).gamerulesConf.getString("HealthInTabType").equalsIgnoreCase("INTEGER")) {
            renderType = RenderType.INTEGER;
        } else {
            renderType = RenderType.HEARTS;
        }
        return  renderType;
    }

}
